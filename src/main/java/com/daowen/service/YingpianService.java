package com.daowen.service;
import java.text.MessageFormat;
import java.util.*;

import com.daowen.entity.*;
import com.daowen.util.JsonResult;
import com.daowen.util.MyUserCF;
import com.daowen.util.ViewHistory;
import com.daowen.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daowen.mapper.YingpianMapper;
import com.daowen.ssm.simplecrud.SimpleBizservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class YingpianService extends SimpleBizservice<YingpianMapper> implements ISiteSearch, ILanmuAdapter {

	@Autowired
	private HuiyuanService huiyuanSrv=null;
	@Autowired
	private YingpianMapper yingpianMapper;

	private String prefix="yingpian_browser_";
	@Autowired
	private LanmuService lanmuSrv=null;
	

	@Autowired
	private BrowserecService browserecSrv=null;
	@Autowired
	private HuiyuanService getHuiyuanSrv=null;


    /**
     * 播放预准备
     */


	public List<YingpianVo> getEntityPlus(Map map){
		return yingpianMapper.getEntityPlus(map);
	}

	public  List<YingpianVo> getEntityPlus(int typeId){
		HashMap<String,Object> map=new HashMap();
		map.put("typeid",typeId);
		return yingpianMapper.getEntityPlus(map);
	}
	public YingpianVo loadPlus(int id){
		HashMap<String,Object> map=new HashMap();
		map.put("id",id);
		return yingpianMapper.loadPlus(map);
	}

	public List<SearchVo>  search(String title){
		List<Yingpian> listVideo= getEntity(" where title like '%"+title+"%'");
		if(listVideo==null)
			return null;
		List<SearchVo> listSearch=new ArrayList<>();
		for(Yingpian yingpian :listVideo){
			SearchVo searchVo=new SearchVo();
			searchVo.setId(yingpian.getId());
			searchVo.setName(yingpian.getTitle());
			searchVo.setHref("/e/yingpianinfo?id="+ yingpian.getId());
			searchVo.setTupian(yingpian.getTupian());
			searchVo.setXtype(3);
			listSearch.add(searchVo);
		}
		return  listSearch;
	}


	@Override
	public int getDefineCode() {
		return LanmuType.Video;
	}

	@Override
	public LanmuContentVo<ImageTextItem> getLanmuContent(Lanmu lanmu) {
		if(lanmu==null)
			return null;
//		List<Yingpian> listYingpian= getTopEntity(" where typeid="+lanmu.getId()+" order by id desc ",10);
		HashMap map = new HashMap();
		map.put("typeid",lanmu.getId());
		map.put("state",2);
		map.put("order"," order by id desc");
		map.put("topcount",10);
		List<YingpianVo> listYingpian=getEntityPlus(map);
		List<ImageTextItem> listIti=new ArrayList<>();
		listYingpian.forEach(c->{
			ImageTextItem iti=new ImageTextItem();

			iti.setName(c.getTitle());
			iti.setHref("/e/yingpianinfo?id="+c.getId());
			iti.setTupian(c.getTupian());
			iti.setPrice(0);
			iti.setClickCount(c.getClickcount());
			listIti.add(iti);
		});
		return new LanmuContentVo<ImageTextItem>(lanmu,listIti);

	}

	@Override
	public List<LanmuVo> getMyLanmus() {
		HashMap<String,Object> map=new HashMap<>();
		map.put("type",this.getDefineCode());
		return lanmuSrv.getEntityPlus(map);
	}

    public List<YingpianVo> getRecomment(Huiyuan huiyuan) {

		if(huiyuan==null)
			return null;

        List<YingpianVo> listYingpian = getEntityPlus(null);
        List<Huiyuan> listHuiyuan=huiyuanSrv.getEntityPlus(null);
        Map<String,Map<String,Double>> mapUsers = new HashMap<>();
        for(Huiyuan h: listHuiyuan) {
           HashMap map = new HashMap();
           map.put("hyid",h.getId());
           map.put("type","yingpian");
           List<Browserec> list = browserecSrv.getEntityPlus(map);
           HashMap<String,Double> mapYingpian=new HashMap<>();
           for (YingpianVo yingpianVo : listYingpian) {

           	Browserec browserec = list.stream()
	          .filter(br->{
	          	 return br.getHyid()==h.getId()&&br.getTargetid()==yingpianVo.getId();
			  }).findAny().orElse(null);
           	 if(browserec!=null)
                mapYingpian.put(String.valueOf(yingpianVo.getId()),Double.valueOf(browserec.getCount()));
			 else
				 mapYingpian.put(String.valueOf(yingpianVo.getId()),0.0);

			}
           mapUsers.put(String.valueOf(h.getId()),mapYingpian);
		}

		String key= MyUserCF.Similar(mapUsers,String.valueOf(huiyuan.getId()));
		System.out.print("相似用户"+key);
        if(key==null)
        	return new ArrayList<>();
        HashMap map2=new HashMap();
        map2.put("hyid",key);
        map2.put("type","yingpian");
		List<Browserec> listRc = browserecSrv.getEntityPlus(map2);
		map2.clear();
		map2.put("ids",listRc);
		return getEntityPlus(map2);

    }

	public YingpianService view(Huiyuan huiyuan, String id) {
		if(huiyuan==null)
			return this;
		Browserec browserec = browserecSrv.load(MessageFormat.format("  where  hyid={0,number,#} and targetid={1} and type=''yingpian''  " ,huiyuan.getId(),id));
		if(browserec==null) {
			browserec = new Browserec();
			browserec.setTargetid(Integer.valueOf(id));
			browserec.setHyid(huiyuan.getId());
			browserec.setType("yingpian");
			browserec.setCount(1);
			browserecSrv.save(browserec);
		}
		else{
			browserec.setCount(browserec.getCount()+1);
			browserecSrv.update(browserec);
		}
		return this;
	}
}
