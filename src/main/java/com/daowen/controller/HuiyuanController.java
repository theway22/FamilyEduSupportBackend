package com.daowen.controller;

import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.daowen.util.JsonResult;
import com.daowen.util.MailUtil;
import com.daowen.util.MimeMessageDescription;
import com.daowen.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.daowen.entity.Huiyuan;
import com.daowen.service.HuiyuanService;
import com.daowen.ssm.simplecrud.SimpleController;
import com.daowen.webcontrol.PagerMetal;

@RestController
public class HuiyuanController extends SimpleController {

	@Autowired
	private HuiyuanService huiyuanSrv=null;



	@ResponseBody
	@PostMapping("/admin/huiyuan/des")
	public JsonResult des() {
		//
		String id = request.getParameter("id");
		String des=request.getParameter("des");
		if (id == null)
			return JsonResult.error(-1, "参数不存在");

		Huiyuan huiyuan =null;
		if(id!=null&&id!=""){
			huiyuan=huiyuanSrv.loadPlus(new Integer(id));
			if (huiyuan == null)
				return JsonResult.error(-2, "不存在的账号");
		}
		huiyuan.setDes(des==null?"":des);
		huiyuanSrv.update(huiyuan);

		return JsonResult.success(1,"成功",huiyuan);

	}
	@ResponseBody
	@PostMapping("/admin/huiyuan/chongzhi")
	public JsonResult chongzhi() {
		String amount = request.getParameter("amount");

		String hyid = request.getParameter("hyid");
		if (hyid == null || hyid == "")
			return JsonResult.error(-1,"账户编号不能为空");
		Huiyuan huiyuan = huiyuanSrv.load(new Integer(hyid));
		if (huiyuan == null)
			return JsonResult.error(-1,"账户不合法");

		huiyuan.setYue(huiyuan.getYue() + Double.valueOf(amount));
		huiyuanSrv.update(huiyuan);
		request.getSession().setAttribute("huiyuan", huiyuan);

		return JsonResult.success(1,"充值成功");
	}


	@PostMapping("/admin/huiyuan/forgetpw")
	public JsonResult forgetpw() {
		String accountname = request.getParameter("accountname");
		Huiyuan h = huiyuanSrv.load("where accountname='" + accountname + "'");
		if (h == null)
			return JsonResult.error(-1, "不存在的账号");
		if(StringUtils.isEmpty(h.getEmail()))
			return JsonResult.error(-2,"没有设置密保邮箱");
		if(!StringUtil.isEmail(h.getEmail()))
			return JsonResult.error(-3,"密码邮箱不合法");
		return JsonResult.success(1,"成功");
	}


	@PostMapping("/admin/huiyuan/sendpwemail")
	public JsonResult sendpwemail() {
		String id = request.getParameter("id");
		Huiyuan h = huiyuanSrv.load("where id=" + id);
		if (h == null)
			return JsonResult.error(-1, "不存在的账号");
		MimeMessageDescription mmd = new MimeMessageDescription();
		mmd.setReceAccount(h.getEmail());
		mmd.setReceAccountRemark(h.getName());
		mmd.setSubject("忘记密码-密码重置邮件");
		mmd.setContent(MessageFormat.format("亲忘记密码<a href=\"http://localhost:9090{0}/e/resetpw.do?id={1,number,#}\">重置密码</a>", request.getContextPath(), h.getId()));
		boolean res = MailUtil.send(mmd);
		if (res)
			return JsonResult.success(1, "邮件发送完成");
		else
			return JsonResult.error(-2, "发送失败,请检查邮箱是否正常");
	}

	@PostMapping("/admin/huiyuan/resetpw")
	public JsonResult resetpw() {
		String repassword1 = request.getParameter("repassword1");
		String repassword2 = request.getParameter("repassword2");

		String id = request.getParameter("id");
		if (id == null || id == "")
			return JsonResult.error(-1,"id不能为空");
		Huiyuan huiyuan = huiyuanSrv.load(new Integer(id));
		if (huiyuan == null)
			return JsonResult.error(-2,"账户数据非法");
		huiyuan.setPassword(repassword1);
		huiyuanSrv.update(huiyuan);
		return JsonResult.success(1,"成功");


	}



	@PostMapping("/admin/huiyuan/modifypaypw")
	public JsonResult modifyPaypw() {

		String paypwd = request.getParameter("paypwd");

		String repassword1 = request.getParameter("repassword1");
		String id = request.getParameter("id");
		if (id == null || id == "")
			return JsonResult.error(-1, "编号不能为空");
		Huiyuan huiyuan = huiyuanSrv.load(new Integer(id));

		if (huiyuan == null)
			return JsonResult.error(-2, "不存在的账号信息");
		if (!huiyuan.getPaypwd().equals(paypwd))
			return JsonResult.error(-3, "原始支付密码不正确");
		huiyuan.setPaypwd(repassword1);
		huiyuanSrv.update(huiyuan);
		return JsonResult.success(1, "更新成功");
	}







	@PostMapping("/admin/huiyuan/login")
	private JsonResult login() {

		String accountname = request.getParameter("accountname");
		String password = request.getParameter("password");

		String filter = MessageFormat.format("where accountname=''{0}'' and password=''{1}''", accountname,password);
		Huiyuan huiyuan = (Huiyuan) huiyuanSrv.load(filter);
		if (huiyuan == null)
			return JsonResult.error(-1, "系统账户和密码不匹配");
		if (!huiyuan.getPassword().equals(password))
			return JsonResult.error(-2, "密码错误");
		huiyuan.setLogtimes(huiyuan.getLogtimes() + 1);

		huiyuanSrv.update(huiyuan);
		request.getSession().setAttribute("huiyuan",huiyuan);
		return JsonResult.success(1, "成功登陆", huiyuan);

	}

	@PostMapping("/admin/huiyuan/save")
	public JsonResult save() {
		String accountname = request.getParameter("accountname");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String idcardno = request.getParameter("idcardno");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String touxiang = request.getParameter("touxiang");
		String sex = request.getParameter("sex");
		String des = request.getParameter("des");
		if (huiyuanSrv.isExist("where accountname='" + accountname + "'"))
			return JsonResult.error(-1, "用户名已经存在");
		Huiyuan huiyuan = new Huiyuan();
		huiyuan.setAccountname(accountname == null ? "" : accountname);
		huiyuan.setPassword(password == null ? "" : password);
		huiyuan.setPaypwd(huiyuan.getPassword());
		if (mobile != null)
			huiyuan.setMobile(mobile);
		else
			huiyuan.setMobile(accountname);
		if (address != null)
			huiyuan.setAddress(address);
		if (sex != null)
			huiyuan.setSex(sex);
		else
			huiyuan.setSex("男");
		huiyuan.setNickname(accountname);
		huiyuan.setName(name);

		huiyuan.setRegdate(new Date());
		huiyuan.setIdcardno(idcardno == null ? "" : idcardno);
		huiyuan.setLogtimes(0);
		if (touxiang != null)
			huiyuan.setTouxiang(touxiang);
		else
			huiyuan.setTouxiang("/upload/nopic.jpg");
		huiyuan.setEmail(email == null ? "" : email);
		huiyuan.setStatus(1);
		huiyuan.setYue(0);
		huiyuan.setDes(des == null ? "" : des);
		huiyuanSrv.save(huiyuan);
		return JsonResult.success(1, "注册成功");

	}

	@PostMapping("/admin/huiyuan/delete")
	public JsonResult delete() {
		String[] ids = request.getParameterValues("ids");
		if (ids == null)
			return JsonResult.error(-1, "编号不能为空");
		String where = " where id in(" + join(",", ids) + ")";
		huiyuanSrv.delete(where);
		return JsonResult.success(1, "删除成功");
	}

	@PostMapping("/admin/huiyuan/update")
	public JsonResult update() {
		String id = request.getParameter("id");
		if (id == null)
			return JsonResult.error(-1, "编号不能为空");
		Huiyuan huiyuan = huiyuanSrv.load(new Integer(id));
		if (huiyuan == null)
			return JsonResult.error(-2, "账号不存在");
		String accountname = request.getParameter("accountname");
		String nickname = request.getParameter("nickname");
		String touxiang = request.getParameter("touxiang");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String name = request.getParameter("name");
		String idcardno = request.getParameter("idcardno");
		String des=request.getParameter("des");
		if (accountname != null)
			huiyuan.setAccountname(accountname);
		huiyuan.setNickname(nickname == null ? "" : nickname);
		huiyuan.setTouxiang(touxiang == null ? "" : touxiang);
		huiyuan.setEmail(email == null ? "" : email);
		huiyuan.setMobile(mobile == null ? "" : mobile);
		huiyuan.setIdcardno(idcardno == null ? "" : idcardno);
		huiyuan.setSex(sex == null ? "" : sex);
		huiyuan.setAddress(address == null ? "" : address);
		huiyuan.setName(name == null ? "" : name);
		huiyuan.setDes(des==null?"":des);
		huiyuanSrv.update(huiyuan);
		return JsonResult.success(1, "更新成功");

	}

	@PostMapping("/admin/huiyuan/modifypw")
	public JsonResult modifyPw() {

		String password = request.getParameter("password");
		String repassword1 = request.getParameter("repassword1");
		String id = request.getParameter("id");
		if (id == null || id == "")
			return JsonResult.error(-1, "编号不存在");
		Huiyuan huiyuan = huiyuanSrv.load("where id=" + id);
		if (huiyuan == null)
			return JsonResult.error(-2, "不存在的账号");

		if (!huiyuan.getPassword().equals(password))
			return JsonResult.error(-3, "原始密码不正确");
		huiyuan.setPassword(repassword1);
		huiyuanSrv.update(huiyuan);
		return JsonResult.success(1, "成功修改");


	}






	@PostMapping({"/admin/huiyuan/load","/admin/huiyuan/info"})
	public JsonResult info() {
		//
		String id = request.getParameter("id");
		String accountname = request.getParameter("accountname");
		if (id == null && accountname == null)
			return JsonResult.error(-1, "参数不存在");

		Huiyuan huiyuan =null;
		if(id!=null&&id!=""){
		    huiyuan=huiyuanSrv.loadPlus(new Integer(id));
		  if (huiyuan == null)
			return JsonResult.error(-2, "不存在的账号");
		}
		if(accountname!=null&&accountname!=""){
			HashMap map = new HashMap();
			map.put("accountname",accountname);
			huiyuan=huiyuanSrv.loadPlus(map);
			if(huiyuan==null)
				return JsonResult.error(-2, "不存在的账号");
		}

		return JsonResult.success(1,"成功",huiyuan);

	}


	@ResponseBody
	@PostMapping("/admin/huiyuan/list")
	public JsonResult list() {
		int pageindex = 1;
		int pagesize = 10;
		// 获取当前分页
		String accountname = request.getParameter("accountname");
		HashMap map = new HashMap();
		if (accountname != null)
			map.put("accountname",accountname);

		String currentpageindex = request.getParameter("currentpageindex");
		// 当前页面尺寸
		String currentpagesize = request.getParameter("pagesize");
		// 设置当前页
		if (currentpageindex != null)
			pageindex = new Integer(currentpageindex);
		// 设置当前页尺寸
		if (currentpagesize != null)
			pagesize = new Integer(currentpagesize);
		PageHelper.startPage(pageindex,pagesize);

		List<Huiyuan> listHuiyuan = huiyuanSrv.getEntityPlus(map);
		return JsonResult.success(1,"获取会员信息",new PageInfo<>(listHuiyuan));
	}

	
	

}
