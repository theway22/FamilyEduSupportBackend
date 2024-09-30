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
import com.daowen.vo.LeavewordVo;
import com.sun.org.glassfish.gmbal.ParameterNames;
import jdk.nashorn.internal.scripts.JS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.daowen.entity.*;
import com.daowen.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.daowen.ssm.simplecrud.SimpleController;
import com.daowen.webcontrol.PagerMetal;

//##{{import}}
@Controller
public class LeavewordController extends SimpleController {

    @Autowired
    private LeavewordService leavewordSrv = null;

    @ResponseBody
    @PostMapping("/admin/leaveword/sendors")
    public JsonResult sendors(){
        String targetid=request.getParameter("targetid");
        HashMap map=new HashMap();
        if(targetid!=null)
            map.put("targetid",targetid);
        return JsonResult.success(1,"成功",leavewordSrv.sendors(map));
    }

    @ResponseBody
    @PostMapping("/admin/leaveword/targets")
    public JsonResult targets(){
        String sendorid=request.getParameter("sendorid");
        HashMap map=new HashMap();
        if(sendorid!=null)
            map.put("sendorid",sendorid);
        return JsonResult.success(1,"成功",leavewordSrv.targets(map));
    }

    //
    @ResponseBody
    @PostMapping("/admin/leaveword/list")
    public JsonResult  list(){
        HashMap<String,Object> map=new HashMap<>();
        String sendorid=request.getParameter("sendorid");
        String targetid=request.getParameter("targetid");
        if(sendorid!=null)
            map.put("sendorid",sendorid);
        if(targetid!=null)
            map.put("targetid",targetid);
        map.put("order","order by id desc");
        List<LeavewordVo> listLeaveword=leavewordSrv.getEntityPlus(map);
        return JsonResult.success(1,"获取留言信息",listLeaveword);
    }

    @ResponseBody
    @PostMapping("/admin/leaveword/delete")
    public JsonResult  delete(){

        String []ids=request.getParameterValues("ids");
        if(ids==null)
            return JsonResult.error(-1,"参数异常");

        for(String id : ids){
            leavewordSrv.delete("where id="+id);
        }
        return JsonResult.success(1,"删除成功");
    }

    @ResponseBody
    @PostMapping("/admin/leaveword/save")
    public JsonResult save() {
        String dcontent = request.getParameter("dcontent");
        String sendorid = request.getParameter("sendorid");
        String targetid = request.getParameter("targetid");
        String replyren = request.getParameter("replyren");
        SimpleDateFormat sdfleaveword = new SimpleDateFormat("yyyy-MM-dd");
        Leaveword leaveword = new Leaveword();
        leaveword.setDcontent(dcontent == null ? "" : dcontent);
        leaveword.setPubtime(new Date());
        leaveword.setState(1);
        leaveword.setTargetid(targetid==null?0:new Integer(targetid));
        leaveword.setSendorid(sendorid == null ? 0 : new Integer(sendorid));
        leaveword.setReplytime(new Date());
        leaveword.setReplyren(replyren == null ? "" : replyren);
        leavewordSrv.save(leaveword);
        return JsonResult.success(1,"留言成功",leaveword);
    }

    @ResponseBody
    @PostMapping("/admin/leaveword/reply")
    public JsonResult reply() {
        String id = request.getParameter("id");
        String replyren = request.getParameter("replyren");
        if (id == null)
            return JsonResult.error(-1,"id不能为空");
        Leaveword leaveword = leavewordSrv.load("where id="+id);
        if (leaveword == null)
            return JsonResult.error(-2,"非法数据");
        String replycontent = request.getParameter("replycontent");
        leaveword.setReplycontent(replycontent);
        leaveword.setReplytime(new Date());
        leaveword.setReplyren(replyren);
        leaveword.setState(2);
        leavewordSrv.update(leaveword);
        return JsonResult.success(1,"成功");

    }



    //##{{methods}}


}
