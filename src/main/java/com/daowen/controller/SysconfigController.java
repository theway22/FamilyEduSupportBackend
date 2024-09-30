package com.daowen.controller;

import com.daowen.entity.Sysconfig;
import com.daowen.service.SysconfigService;
import com.daowen.service.SysconfigitemService;
import com.daowen.ssm.simplecrud.SimpleController;
import com.daowen.util.JsonResult;
import com.daowen.vo.SysconfigVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**************************
 *
 * 系统介绍控制
 *
 */
@RestController
public class SysconfigController extends SimpleController {
    @Autowired
    private SysconfigService sysconfigSrv = null;
    @Autowired
    private SysconfigitemService sysconfigitemSrv=null;

    @PostMapping("/admin/sysconfig/delete")
    public JsonResult delete() {
        String[] ids = request.getParameterValues("ids");
        if (ids == null)
            return JsonResult.error(-1, "ids不能为空");
        for(String id :ids){
           sysconfigSrv.delete("where id="+id);
           sysconfigitemSrv.delete("where cfgid="+id);
        }
        return JsonResult.success(1, "成功");
    }

    @PostMapping("/admin/sysconfig/save")
    public JsonResult save() {

        String name = request.getParameter("name");
        Sysconfig sysconfig = new Sysconfig();
        sysconfig.setName(name == null ? "" : name);
        //产生验证
        Boolean validateresult = sysconfigSrv.isExist("where name='" + name + "'");
        if (validateresult)
            return JsonResult.error(-1,"已存在的名称");
        sysconfigSrv.save(sysconfig);
        return JsonResult.error(1,"新增成功",sysconfig);
    }

    @PostMapping("/admin/sysconfig/update")
    public JsonResult update() {
        String id = request.getParameter("id");
        if (id == null)
            return JsonResult.error(-1,"id不能为空");
        Sysconfig sysconfig = sysconfigSrv.load(new Integer(id));
        if (sysconfig == null)
            return JsonResult.error(-2,"非法数据");
        String name = request.getParameter("name");
        sysconfig.setName(name);
        sysconfigSrv.update(sysconfig);
        return JsonResult.success(1,"更新成功",sysconfig);
    }

    @PostMapping("/admin/sysconfig/load")
    public JsonResult load() {
        //
        String id = request.getParameter("id");
        if (id == null)
            return JsonResult.error(-1,"id不能为空");
        SysconfigVo sysconfig = sysconfigSrv.loadPlus(new Integer(id));
        if (sysconfig == null)
            return JsonResult.error(-2,"非法数据");
        return JsonResult.success(1,"成功",sysconfig);
    }


    @PostMapping("/admin/sysconfig/list")
    public JsonResult list() {
        HashMap map = new HashMap();
        String name = request.getParameter("name");
        if (name != null)
            map.put("name",name);
        //
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
        PageHelper.startPage(pageindex,pagesize);
        List<SysconfigVo> listSysconfig = sysconfigSrv.getEntityPlus(map);
        PageInfo pageInfo=new PageInfo(listSysconfig);
        return JsonResult.success(1,"成功",pageInfo);

    }
}
