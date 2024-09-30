package com.daowen.controller;

import java.io.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daowen.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.daowen.entity.*;
import com.daowen.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.daowen.ssm.simplecrud.SimpleController;
import com.daowen.webcontrol.PagerMetal;
import org.springframework.web.bind.annotation.ResponseBody;

//##{{import}}
@Controller
public class StagController extends SimpleController {

    @Autowired
    private StagService stagSrv = null;

    @Override
    @RequestMapping("/admin/stagmanager.do")
    public void mapping(HttpServletRequest request, HttpServletResponse response) {
        mappingMethod(request, response);
    }
    //


    @ResponseBody
    @PostMapping("/admin/stag/list")
    public JsonResult ajaxlist() {
        List<Stag> list = stagSrv.getEntity("");
        return JsonResult.success(1, "获取标签类别", list);
    }

    //新增标签
    public void save() {

        String forwardurl = request.getParameter("forwardurl");
        //验证错误url
        String errorurl = request.getParameter("errorurl");


        String name = request.getParameter("name");

        SimpleDateFormat sdfstag = new SimpleDateFormat("yyyy-MM-dd");
        Stag stag = new Stag();


        stag.setName(name == null ? "" : name);


        //end forEach

        Boolean validateresult = stagSrv.isExist("  where  name='" + name + "'");
        if (validateresult) {
            dispatchParams(request, response);
            request.setAttribute("errormsg", "<label class='error'>已存在的信息</label>");
            request.setAttribute("stag", stag);
            request.setAttribute("actiontype", "save");
            forward(errorurl);
            return;
        }


        stagSrv.save(stag);
        if (forwardurl == null) {
            forwardurl = "/admin/stagmanager.do?actiontype=get";
        }
        redirect(forwardurl);
    }

    //新增标签
    public void update() {
        String forwardurl = request.getParameter("forwardurl");
        //验证错误url
        String errorurl = request.getParameter("errorurl");
        String id = request.getParameter("id");
        if (id == null)
            return;
        Stag stag = stagSrv.load("where id=" + id);
        if (stag == null)
            return;


        String name = request.getParameter("name");

        SimpleDateFormat sdfstag = new SimpleDateFormat("yyyy-MM-dd");


        stag.setName(name == null ? "" : name);


        stagSrv.update(stag);
        if (forwardurl == null) {
            forwardurl = "/admin/stagmanager.do?actiontype=get";
        }
        redirect(forwardurl);
    }

    public void delete() {
        String[] ids = request.getParameterValues("ids");
        if (ids == null)
            return;
        String spliter = ",";
        String where = " where id  in(" + join(spliter, ids) + ")";
        System.out.println("where=" + where);
        stagSrv.delete(where);
    }

    public void load() {
        String id = request.getParameter("id");
        String actiontype = "save";
        dispatchParams(request, response);
        if (id != null) {
            Stag stag = stagSrv.load("where id=" + id);
            if (stag != null) {
                request.setAttribute("stag", stag);
            }
            actiontype = "update";
            request.setAttribute("id", id);
        }
        request.setAttribute("actiontype", actiontype);

        String forwardurl = request.getParameter("forwardurl");
        System.out.println("forwardurl=" + forwardurl);
        if (forwardurl == null) {
            forwardurl = "/admin/stagadd.jsp";
        }
        forward(forwardurl);
    }

    //查询数据
    public void get() {
        HashMap<String, Object> map = new HashMap<String, Object>();

        String name = request.getParameter("name");
        if (name != null)
            map.put("name", name);


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

        PageHelper.startPage(pageindex, pagesize);
        List<Stag> listStag = stagSrv.getEntityPlus(map);

        request.setAttribute("listStag", listStag);
        PageInfo<Stag> pageInfo = new PageInfo(listStag);
        PagerMetal pm = new PagerMetal((int) pageInfo.getTotal());
        //设置尺寸
        pm.setPagesize(pagesize);
        //设置当前显示页
        pm.setCurpageindex(pageindex);
        // 设置分页信息
        request.setAttribute("pagermetal", pm);
        //分发请求参数
        dispatchParams(request, response);
        String forwardurl = request.getParameter("forwardurl");
        System.out.println("forwardurl=" + forwardurl);
        if (forwardurl == null) {
            forwardurl = "/admin/stagmanager.jsp";
        }
        forward(forwardurl);
    }

    //##{{methods}}


}
