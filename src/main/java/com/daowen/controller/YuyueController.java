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
public class YuyueController extends SimpleController {

    @Autowired
    private YuyueService yuyueSrv = null;


    //
    @PostMapping("/admin/yuyue/save")
    public JsonResult save() {

        String title = request.getParameter("title");

        String yydate = request.getParameter("yydate");

        String mobile = request.getParameter("mobile");

        String state = request.getParameter("state");

        String hyid = request.getParameter("hyid");

        String targetid = request.getParameter("targetid");

        String dcontent = request.getParameter("dcontent");

        String replydes = request.getParameter("replydes");

        SimpleDateFormat sdfyuyue = new SimpleDateFormat("yyyy-MM-dd");
        Yuyue yuyue = new Yuyue();


        yuyue.setTitle(title == null ? "" : title);


        if (yydate != null) {
            try {
                yuyue.setYydate(sdfyuyue.parse(yydate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            yuyue.setYydate(new Date());
        }


        yuyue.setMobile(mobile == null ? "" : mobile);


        yuyue.setState(1);


        yuyue.setHyid(hyid == null ? 0 : new Integer(hyid));


        yuyue.setTargetid(targetid == null ? 0 : new Integer(targetid));


        yuyue.setDcontent(dcontent == null ? "" : dcontent);


        yuyue.setReplydes(replydes == null ? "" : replydes);


        //end forEach

        Boolean validateresult = yuyueSrv.isExist("  where  title='" + title + "'");
        if (validateresult)
            return JsonResult.error(-1, "已存在的记录");

        yuyueSrv.save(yuyue);
        return JsonResult.success(1, "成功", yuyue);
    }



    @PostMapping("/admin/yuyue/delete")
    public JsonResult delete() {
        String[] ids = request.getParameterValues("ids");
        if (ids == null)
            return JsonResult.error(-1, "ids不能为空");
        String spliter = ",";
        String where = " where id  in(" + join(spliter, ids) + ")";
        yuyueSrv.delete(where);
        return JsonResult.success(1, "不能为空");
    }

    @RequestMapping("/admin/yuyue/load")
    public JsonResult load() {
        String id = request.getParameter("id");

        if (id == null)
            return JsonResult.error(-1, "ID不能为空");
        Yuyue yuyue = yuyueSrv.loadPlus(new Integer(id));
        if (yuyue == null)
            return JsonResult.error(-2, "非法数据");
        return JsonResult.success(1, "成功", yuyue);

    }

    @RequestMapping("/admin/yuyue/info")
    public JsonResult info() {
        String id = request.getParameter("id");

        if (id == null)
            return JsonResult.error(-1, "ID不能为空");
        Yuyue yuyue = yuyueSrv.loadPlus(new Integer(id));
        if (yuyue == null)
            return JsonResult.error(-2, "非法数据");
        return JsonResult.success(1, "成功", yuyue);

    }


    @PostMapping("/admin/yuyue/list")
    public JsonResult list() {

        HashMap<String, Object> map = new HashMap<>();
        String ispaged = request.getParameter("ispaged");

        String title = request.getParameter("title");
        String hyid = request.getParameter("hyid");
        String targetid = request.getParameter("targetid");
        if (title != null)
            map.put("title", title);
        if(hyid!=null)
            map.put("hyid",hyid);
        if(targetid!=null)
            map.put("targetid",targetid);


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
            List<Yuyue> listYuyue = yuyueSrv.getEntityPlus(map);
            PageInfo<Yuyue> pageInfo = new PageInfo<Yuyue>(listYuyue);
            return JsonResult.success(1, "成功", pageInfo);
        }
        return JsonResult.success(1, "获取成功", yuyueSrv.getEntityPlus(map));


    }

    //审批
    @PostMapping("/admin/yuyue/shenpi")
    public JsonResult  shenpi(){

        String id=request.getParameter("id");

        String  state =request.getParameter("state");
        String  reply=request.getParameter("reply");
        String  shenpiren=request.getParameter("shenpiren");
        int stateCode=2;
        //验证错误url
        String errorurl=request.getParameter("errorurl");
        if(id==null)
            return JsonResult.error(-1,"id不能为空");;
        Yuyue  yuyue=yuyueSrv.load(" where id="+ id);

        if(yuyue==null)
            return JsonResult.error(-1,"数据非法");;
        if(state!=null)
            stateCode=Integer.parseInt(state);
        yuyue.setState(stateCode);
        yuyueSrv.update(yuyue);
        return JsonResult.success(1,"审核成功");


    }

    //##{{methods}}


}
