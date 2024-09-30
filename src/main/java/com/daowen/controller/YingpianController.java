package com.daowen.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.daowen.entity.Huiyuan;
import com.daowen.service.LanmuService;
import com.daowen.util.JsonResult;
import com.daowen.vo.LanmuVo;
import com.daowen.vo.XinxiVo;
import com.daowen.vo.YingpianVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daowen.entity.Yingpian;
import com.daowen.service.YingpianService;

import com.daowen.ssm.simplecrud.SimpleController;
import com.daowen.webcontrol.PagerMetal;
import org.springframework.web.bind.annotation.ResponseBody;

/**************************
 *
 * 影视控制
 *
 */
@Controller
public class YingpianController extends SimpleController {
	@Autowired
	private YingpianService yingpianSrv = null;
	@Autowired
	private LanmuService ypcateSrv = null;



	@ResponseBody
	@PostMapping("/admin/yingpian/hotplay")
	public JsonResult hotplay(){
		HashMap map=new HashMap();
		map.put("order","order by playcount desc");
		map.put("topcount",5);
		List<YingpianVo> listYingpian=yingpianSrv.getEntityPlus(map);
		return JsonResult.success(1,"热门视频",listYingpian);

	}

	@ResponseBody
	@PostMapping("/admin/yingpian/recomment")
	public  JsonResult recomment(){
		Huiyuan temhy=(Huiyuan)request.getSession().getAttribute("huiyuan");
		if(temhy==null)
			return JsonResult.success(1,"暂无相关信息推荐");
		//获取用户浏览记录
		List<YingpianVo> listRecomment=yingpianSrv.getRecomment(temhy);

		return JsonResult.success(1,"猜你喜欢",listRecomment);


	}

	@ResponseBody
	@PostMapping("/admin/yingpian/list")
	public JsonResult list(){
		HashMap<String,Object> map=new HashMap<String,Object>();
		String ispaged=request.getParameter("ispaged");
		String title=request.getParameter("title");
		String pubren=request.getParameter("pubren");
		String order=request.getParameter("order");
		String typeid=request.getParameter("typeid");
		String subtypeid=request.getParameter("subtypeid");
		String state=request.getParameter("state");
		if(title!=null)
			map.put("title",title);
		if(pubren!=null)
			map.put("pubren",pubren);
		if(state!=null)
			map.put("state",state);
		if(order!=null)
			map.put("order",order);
		if(typeid!=null)
			map.put("typeid",typeid);
		if(subtypeid!=null)
			map.put("subtypeid",subtypeid);
		map.put("order"," order by id desc ");

		int pageindex = 1;
		int pagesize = 14;
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


		if(!"-1".equals(ispaged)) {
			PageHelper.startPage(pageindex,pagesize);
			PageInfo<YingpianVo> pageInfo=new PageInfo(  yingpianSrv.getEntityPlus(map) );
			return JsonResult.success(1,"获取影片类别",pageInfo);
		}

		return JsonResult.success(1,"",yingpianSrv.getEntityPlus(map));


	}



	@ResponseBody
	@PostMapping("/admin/yingpian/mylanmu")
	public JsonResult mylanmu(){
		List<LanmuVo> listLanmu=yingpianSrv.getMyLanmus();
		return JsonResult.success(1,"获取栏目",listLanmu);
	}

	@ResponseBody
	@PostMapping("/admin/yingpian/delete")
	public  JsonResult  delete(){
		String[] ids = request.getParameterValues("ids");
		if (ids == null)
			return JsonResult.error(-1,"ids不能为空");
		String spliter = ",";
		String where = " where id  in(" + join(spliter, ids)+ ")";
		yingpianSrv.delete(where);
		return  JsonResult.success(1,"不能为空");
	}
	@ResponseBody
	@PostMapping("/admin/yingpian/cascadelanmu")
	public JsonResult cascadeList(){

		List<LanmuVo> listLanmu = yingpianSrv.getMyLanmus();
		JSONArray jsonArray=new JSONArray();
		if(listLanmu!=null)
			listLanmu.forEach(c->{
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("value",c.getId());
				jsonObject.put("label",c.getName());
				if(c.getSubtypes()!=null){
					JSONArray array = new JSONArray();
					c.getSubtypes().forEach(subtype->{
						JSONObject cobj=new JSONObject();
						cobj.put("label",subtype.getName());
						cobj.put("value",subtype.getId());
						array.add(cobj);
						jsonObject.put("children",array);
					});
				}
				jsonArray.add(jsonObject);
			});
		return JsonResult.success(1,"获取成功",jsonArray);
	}
	@Override
	@RequestMapping("/admin/yingpianmanager.do")
	public void mapping(HttpServletRequest request, HttpServletResponse response) {
		mappingMethod(request, response);
	}

	public void shenpi() {
		String id = request.getParameter("id");
		String forwardurl = request.getParameter("forwardurl");
		String state = request.getParameter("state");
		String reply = request.getParameter("reply");
		String shenpiren = request.getParameter("shenpiren");
		int stateCode = 3;
		// 验证错误url
		String errorurl = request.getParameter("errorurl");
		if (id == null)
			return;
		Yingpian yingpian = yingpianSrv.load(" where id=" + id);
		if (yingpian == null)
			return;
		if (state != null)
			stateCode = Integer.parseInt(state);
		yingpian.setState(stateCode);
		yingpianSrv.update(yingpian);
		if (forwardurl == null) {
			forwardurl = "/admin/yingpianmanager.do?actiontype=get";
		}
		redirect(forwardurl);
	}

	@ResponseBody
	@PostMapping("/admin/yingpian/agree")
	public JsonResult agree() {
		String id = request.getParameter("id");
		if (id == null)
			return JsonResult.error(-1,"请输入id 参数");
		Yingpian yingpian = yingpianSrv.load(new Integer(id));
		if (yingpian == null)
			return JsonResult.error(-2,"参数异常");
		yingpian.setAgreecount(yingpian.getAgreecount() + 1);
		yingpianSrv.update(yingpian);
		return JsonResult.success(1,"成功点赞",yingpian.getAgreecount());

	}
	@ResponseBody
	@PostMapping("/admin/yingpian/against")
	public JsonResult against() {
		String id = request.getParameter("id");
		if (id == null)
			return JsonResult.error(-1,"请输入id 参数");
		Yingpian yingpian = yingpianSrv.load(new Integer(id));
		if (yingpian == null)
			return JsonResult.error(-2,"参数异常");
		yingpian.setAgainstcount(yingpian.getAgainstcount() + 1);
		yingpianSrv.update(yingpian);
		response.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
		return JsonResult.success(1,"成功点赞",yingpian.getAgainstcount());

	}


    @ResponseBody
	@RequestMapping("/admin/yingpian/info")
	public  JsonResult  info(){
		String id=request.getParameter("id");

		if(id==null)
			return JsonResult.error(-1,"ID不能为空");
		Yingpian  yingpian=yingpianSrv.loadPlus(new Integer(id));
		if(yingpian==null)
			return JsonResult.error(-2,"非法数据");
		Huiyuan temhy=(Huiyuan)request.getSession().getAttribute("huiyuan");
		yingpianSrv.view(temhy,id);

		return  JsonResult.success(1,"成功",yingpian);

	}

    @ResponseBody
    @RequestMapping("/admin/yingpian/save")
	public JsonResult save() {
		String title = request.getParameter("title");
		String pubren = request.getParameter("pubren");
		String clickcount = request.getParameter("clickcount");
		String alphabetindex = request.getParameter("alphabetindex");
		String des = request.getParameter("des");
		String xshowtype = request.getParameter("xshowtype");
		String remoteurl = request.getParameter("remoteurl");
		String jifen = request.getParameter("jifen");

		String tupian = request.getParameter("tupian");
		String typeid = request.getParameter("typeid");
		String subtitle = request.getParameter("subtitle");
		String tags = request.getParameter("tags");
		String state = request.getParameter("state");
		String subtypeid=request.getParameter("subtypeid");
		SimpleDateFormat sdfyingpian = new SimpleDateFormat("yyyy-MM-dd");
		Yingpian yingpian = new Yingpian();
		yingpian.setTitle(title == null ? "" : title);
		yingpian.setPubren(pubren == null ? "" : pubren);
		yingpian.setPubtime(new Date());
		yingpian.setAgainstcount(0);
		yingpian.setAgreecount(0);
		yingpian.setDlcount(0);
		yingpian.setPlaycount(0);
		yingpian.setJifen(jifen==null?0:new Integer(jifen));
		if (state != null)
			yingpian.setState(Integer.parseInt(state));
		else
			yingpian.setState(1);
		yingpian.setClickcount(clickcount == null ? 0 : new Integer(clickcount));
		yingpian.setDes(des == null ? "" : des);
		yingpian.setXshowtype(xshowtype == null ? 0 : new Integer(xshowtype));

		yingpian.setRemoteurl(remoteurl == null ? "" : remoteurl);

		yingpian.setTupian(tupian == null ? "" : tupian);
		yingpian.setTypeid(typeid == null ? 0 : new Integer(typeid));
		yingpian.setSubtitle(subtitle == null ? "" : subtitle);
		yingpian.setAlphabetindex(alphabetindex == null ? "" : alphabetindex);
		yingpian.setSubtypeid(subtypeid==null?0:new Integer(subtypeid));
		yingpian.setTags(tags == null ? "" : tags);

		yingpianSrv.save(yingpian);
		return JsonResult.success(1,"成功");
	}


    @ResponseBody
    @RequestMapping("/admin/yingpian/update")
	public JsonResult update() {

		String id = request.getParameter("id");
		if (id == null)
			return JsonResult.error(-1,"id不能为空");
		Yingpian yingpian = yingpianSrv.load(new Integer(id));
		if (yingpian == null)
			return JsonResult.error(-1,"数据非法");
		String xshowtype = request.getParameter("xshowtype");
		String remoteurl = request.getParameter("remoteurl");

		String title = request.getParameter("title");
		String typeid = request.getParameter("typeid");
		String alphabetindex = request.getParameter("alphabetindex");
		String des = request.getParameter("des");
		String tupian = request.getParameter("tupian");
		String subtitle = request.getParameter("subtitle");
		String subtypeid=request.getParameter("subtypeid");
		String jifen=request.getParameter("jifen");
		String tags = request.getParameter("tags");
		SimpleDateFormat sdfyingpian = new SimpleDateFormat("yyyy-MM-dd");
		yingpian.setTitle(title);
		yingpian.setXshowtype(xshowtype == null ? 0 : new Integer(xshowtype));

		yingpian.setRemoteurl(remoteurl == null ? "" : remoteurl);
		yingpian.setAlphabetindex(alphabetindex == null ? "" : alphabetindex);
		yingpian.setTypeid(typeid == null ? 0 : new Integer(typeid));
		yingpian.setSubtitle(subtitle == null ? "" : subtitle);
		yingpian.setSubtypeid(subtypeid==null?0:new Integer(subtypeid));
		yingpian.setJifen(jifen==null?0:new Integer(jifen));
		yingpian.setDes(des);
		yingpian.setTupian(tupian);
		yingpian.setTags(tags == null ? "" : tags);

		yingpianSrv.update(yingpian);
		return JsonResult.success(1,"成功");
	}

	@ResponseBody
	@RequestMapping("/admin/yingpian/load")
	public  JsonResult  load(){
		String id=request.getParameter("id");

		if(id==null)
			return JsonResult.error(-1,"ID不能为空");
		Yingpian  yingpian=yingpianSrv.loadPlus(new Integer(id));
		if(yingpian==null)
			return JsonResult.error(-2,"非法数据");
		return  JsonResult.success(1,"成功",yingpian);

	}


}
