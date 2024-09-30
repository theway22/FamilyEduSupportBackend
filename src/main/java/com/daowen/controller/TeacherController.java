package com.daowen.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.daowen.util.JsonResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.daowen.entity.*;
import com.daowen.service.*;
import com.daowen.ssm.simplecrud.SimpleController;
import org.springframework.web.bind.annotation.RestController;

//##{{import}}
@RestController
public class TeacherController extends SimpleController {

    @Autowired
    private TeacherService teacherSrv = null;


    //
    @PostMapping("/admin/teacher/save")
    public JsonResult save() {

        String tno = request.getParameter("tno");

        String password = request.getParameter("password");

        String sex = request.getParameter("sex");

        String jiguan = request.getParameter("jiguan");

        String xueli = request.getParameter("xueli");

        String photo = request.getParameter("photo");

        String nation = request.getParameter("nation");

        String name = request.getParameter("name");

        String email = request.getParameter("email");

        String tel = request.getParameter("tel");

        String zhicheng = request.getParameter("zhicheng");

        String major = request.getParameter("major");

        String jieshao = request.getParameter("jieshao");

        SimpleDateFormat sdfteacher = new SimpleDateFormat("yyyy-MM-dd");
        Teacher teacher = new Teacher();


        teacher.setTno(tno == null ? "" : tno);


        teacher.setPassword(password == null ? "123456" : password);


        teacher.setSex(sex == null ? "男" : sex);


        teacher.setJiguan(jiguan == null ? "" : jiguan);


        teacher.setXueli(xueli == null ? "" : xueli);


        teacher.setPhoto(photo == null ? "" : photo);


        teacher.setNation(nation == null ? "" : nation);


        teacher.setName(name == null ? "" : name);


        teacher.setEmail(email == null ? "" : email);


        teacher.setTel(tel == null ? "" : tel);


        teacher.setZhicheng(zhicheng == null ? "" : zhicheng);


        teacher.setMajor(major == null ? "" : major);


        teacher.setJieshao(jieshao == null ? "" : jieshao);
        Boolean validateresult = teacherSrv.isExist("  where  tno='" + tno + "'");
        if (validateresult)
            return JsonResult.error(-1, "已存在的工号");

        teacherSrv.save(teacher);
        return JsonResult.success(1, "成功", teacher);
    }

    @PostMapping("/admin/teacher/update")
    public JsonResult update() {

        String id = request.getParameter("id");
        if (id == null)
            return JsonResult.error(-1, "ID不能为空");
        Teacher teacher = teacherSrv.load("where id=" + id);
        if (teacher == null)
            return JsonResult.error(-2, "非法数据");

        String tno = request.getParameter("tno");
        String sex = request.getParameter("sex");
        String jiguan = request.getParameter("jiguan");
        String xueli = request.getParameter("xueli");
        String photo = request.getParameter("photo");
        String nation = request.getParameter("nation");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        String zhicheng = request.getParameter("zhicheng");
        String major = request.getParameter("major");
        String jieshao = request.getParameter("jieshao");
        teacher.setTno(tno == null ? "" : tno);
        teacher.setSex(sex == null ? "" : sex);
        teacher.setJiguan(jiguan == null ? "" : jiguan);
        teacher.setXueli(xueli == null ? "" : xueli);
        teacher.setPhoto(photo == null ? "" : photo);
        teacher.setNation(nation == null ? "" : nation);
        teacher.setName(name == null ? "" : name);
        teacher.setEmail(email == null ? "" : email);
        teacher.setTel(tel == null ? "" : tel);
        teacher.setZhicheng(zhicheng == null ? "" : zhicheng);
        teacher.setMajor(major == null ? "" : major);
        teacher.setJieshao(jieshao == null ? "" : jieshao);
        teacherSrv.update(teacher);
        return JsonResult.success(1, "成功", teacher);

    }

    @PostMapping("/admin/teacher/delete")
    public JsonResult delete() {
        String[] ids = request.getParameterValues("ids");
        if (ids == null)
            return JsonResult.error(-1, "ids不能为空");
        String spliter = ",";
        String where = " where id  in(" + join(spliter, ids) + ")";
        teacherSrv.delete(where);
        return JsonResult.success(1, "不能为空");
    }

    @RequestMapping({"/admin/teacher/load","admin/teacher/info"})
    public JsonResult load() {
        String id = request.getParameter("id");

        if (id == null)
            return JsonResult.error(-1, "ID不能为空");
        Teacher teacher = teacherSrv.loadPlus(new Integer(id));
        if (teacher == null)
            return JsonResult.error(-2, "非法数据");
        return JsonResult.success(1, "成功", teacher);

    }



    @PostMapping("/admin/teacher/modifypw")
    public JsonResult modifyPw() {
        String password1 = request.getParameter("password1");
        String repassword1 = request.getParameter("repassword1");
        String id = request.getParameter("id");
        if (id == null || id == "")
            return JsonResult.error(-1,"id不能为空");
        Teacher teacher = teacherSrv.loadPlus(new Integer(id));
        if(teacher==null)
            return  JsonResult.error(-2,"数据非法");
        if(!password1.equals(teacher.getPassword()))
            return JsonResult.error(-3,"原始密码不正确");
        teacher.setPassword(repassword1);
        teacherSrv.update(teacher);

        return JsonResult.success(1,"密码修改成功");

    }
    @PostMapping("/admin/teacher/myteacher")
    public JsonResult myteacher() {

        HashMap<String, Object> map = new HashMap<>();

        String bjid = request.getParameter("bjid");
        if (bjid != null)
            map.put("bjid", bjid);
        return JsonResult.success(1, "获取成功", teacherSrv.getMyteacher(map));


    }
    @PostMapping("/admin/teacher/list")
    public JsonResult list() {

        HashMap<String, Object> map = new HashMap<>();
        String ispaged = request.getParameter("ispaged");

        String tno = request.getParameter("tno");
        if (tno != null)
            map.put("tno", tno);

        int pageindex = 1;
        int pagesize = 10;
        // 获取当前分页
        String currentpageindex = request.getParameter("currentpageindex");
        // 当前页面尺寸
        String currentpagesize = request.getParameter("pagesize");
        // 设置当前页
        if (currentpageindex != null)
            pageindex = new Integer(currentpageindex);
        // 设置当前页尺寸
        if (currentpagesize != null)
            pagesize = new Integer(currentpagesize);
        if (!"-1".equals(ispaged)) {
            PageHelper.startPage(pageindex, pagesize);
            List<Teacher> listTeacher = teacherSrv.getEntityPlus(map);
            PageInfo<Teacher> pageInfo = new PageInfo<Teacher>(listTeacher);
            return JsonResult.success(1, "成功", pageInfo);
        }
        return JsonResult.success(1, "获取成功", teacherSrv.getEntityPlus(map));


    }

    //##{{methods}}


}
