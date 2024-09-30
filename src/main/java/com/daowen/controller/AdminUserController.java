package com.daowen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daowen.entity.Huiyuan;

import com.daowen.entity.Teacher;
import com.daowen.service.HuiyuanService;

import com.daowen.service.TeacherService;
import com.daowen.util.JsonResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daowen.entity.Users;
import com.daowen.service.UsersService;
import com.daowen.ssm.simplecrud.SimpleController;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class AdminUserController extends SimpleController {

	@Autowired
	private UsersService usersService;
	@Autowired
	private TeacherService teacherSrv=null;
	@Autowired
	private HuiyuanService huiyuanSrv=null;
	@ResponseBody
	@PostMapping("/admin/admin/login")
	public JsonResult login() {
		String usertype = request.getParameter("usertype");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (usertype != null && usertype.equals("1")) {
			return adminLogin(username,password,1);
		}
		if (usertype != null && usertype.equals("2")) {
			return huiyuanLogin(username,password);
		}

		if (usertype != null && usertype.equals("3")) {
			return teacherLogin(username,password);
		}
		return JsonResult.error(-2,"账户类型不对");
	}




	private JsonResult teacherLogin(String username,String password) {


		Teacher u = teacherSrv.load(" where tno='" + username
				+ "' and password='" + password + "'");

		if (u == null)
			return JsonResult.error(-1,"不合法账户");

		HttpSession session = request.getSession();

		session.setAttribute("teacher", u);
		return JsonResult.success(1,"登录成功",u);

	}



	private JsonResult huiyuanLogin(String username,String password) {

		HashMap map = new HashMap();
		map.put("accountname",username);
		Huiyuan u = huiyuanSrv.loadPlus(map);
		if (u == null)
			return JsonResult.error(-1,"不合法账户");
		if(!password.equals(u.getPassword()))
			return JsonResult.error(-1,"账号密码不匹配");
		HttpSession session = request.getSession();
		session.removeAttribute("users");
		session.removeAttribute("teacher");
		session.setAttribute("huiyuan", u);

		return  JsonResult.success(1,"登录成功",u);

	}

	private JsonResult adminLogin(String username ,String password,int type) {


		HashMap<String,Object> map=new HashMap<>();
		map.put("username",username);
		Users u = usersService.loadPlus(map);
		if (u == null) {
			return JsonResult.error(-1,"用户名不存在");
		}

		if (password!=null&&!password.equals(u.getPassword())) {
			return JsonResult.error(-3,"用户名和密码不匹配");
		}
		if(u.getRoleid()!=type){
			return JsonResult.error(-2,"用户类型不对");
		}
		usersService.executeUpdate("update users set logtimes=logtimes+1 where id="+u.getId());

		return JsonResult.success(1,"登录成功",u);
	}




	@PostMapping("/admin/admin/exit")
	@ResponseBody
	public JsonResult exit(){
		String usertype=request.getParameter("usertype");
		if(usertype!=null&&usertype.equals("1")) {
			if (request.getSession().getAttribute("users") != null) {
				System.out.println("系统退出");
				request.getSession().removeAttribute("users");
			}
		}

		if(usertype!=null&&usertype.equals("2")) {
			if (request.getSession().getAttribute("huiyuan") != null) {
				System.out.println("系统退出");
				request.getSession().removeAttribute("huiyuan");
			}
		}




		return  JsonResult.success(1,"退出成功");
	}



}
