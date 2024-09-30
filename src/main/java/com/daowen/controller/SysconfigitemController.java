package com.daowen.controller;

import com.daowen.entity.Sysconfig;
import com.daowen.entity.Sysconfigitem;
import com.daowen.service.SysconfigService;
import com.daowen.service.SysconfigitemService;
import com.daowen.ssm.simplecrud.SimpleController;
import com.daowen.util.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SysconfigitemController extends SimpleController {
	@Autowired
	private SysconfigitemService sysconfigitemSrv = null;
	
	@Autowired
	private SysconfigService sysconfigSrv=null;

	@PostMapping("/admin/sysconfigitem/delete")
	public JsonResult delete() {
		String[] ids = request.getParameterValues("ids");
		if (ids == null)
			return JsonResult.error(-1,"ids不能为空");
		String where = " where id  in(" + StringUtils.join(ids,",") + ")";
		System.out.println("where=" + where);
		sysconfigitemSrv.delete(where);
		return JsonResult.success(1,"成功");
	}

	@PostMapping("/admin/sysconfigitem/save")
	public JsonResult save() {

		String title = request.getParameter("title");
		String dcontent = request.getParameter("dcontent");
		String cfgid = request.getParameter("cfgid");
		String type=request.getParameter("type");
		String href=request.getParameter("href");
		Sysconfigitem sysconfigitem = new Sysconfigitem();
		sysconfigitem.setTitle(title == null ? "" : title);
		sysconfigitem.setDcontent(dcontent == null ? "" : dcontent);
		sysconfigitem.setCfgid(cfgid == null ? 0 : new Integer(cfgid));
		sysconfigitem.setHref(href==null?"":href);
		sysconfigitem.setType(type==null?1:new Integer(type));
		sysconfigitemSrv.save(sysconfigitem);
		return JsonResult.success(1,"保存成功",sysconfigitem);
	}

	@PostMapping("/admin/sysconfigitem/update")
	public JsonResult update() {
		String forwardurl = request.getParameter("forwardurl");
		String id = request.getParameter("id");
		if (id == null)
			return JsonResult.error(-1,"ID不能为空");
		Sysconfigitem sysconfigitem = sysconfigitemSrv.load(new Integer(id));
		if (sysconfigitem == null)
			return JsonResult.error(-2,"非法的数据");
		String title = request.getParameter("title");
		String dcontent = request.getParameter("dcontent");
		String cfgid = request.getParameter("cfgid");
		String type=request.getParameter("type");
		String href=request.getParameter("href");
		sysconfigitem.setHref(href==null?"":href);
		sysconfigitem.setType(type==null?1:new Integer(type));
		sysconfigitem.setTitle(title);
		sysconfigitem.setDcontent(dcontent);
		sysconfigitem.setCfgid(cfgid == null ? 0 : new Integer(cfgid));
		sysconfigitemSrv.update(sysconfigitem);
		return JsonResult.success(1,"保存成功",sysconfigitem);
	}

	@PostMapping("/admin/sysconfigitem/load")
	public JsonResult load() {
		//
		String id = request.getParameter("id");
		if (id == null)
			return JsonResult.error(-1,"ID不能为空");
		Sysconfigitem sysconfigitem = sysconfigitemSrv.load(new Integer(id));
		if (sysconfigitem == null)
			return JsonResult.error(-2,"非法的数据");

		return JsonResult.success(1,"成功",sysconfigitem);

	}


}
