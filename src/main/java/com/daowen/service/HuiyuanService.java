package com.daowen.service;

import com.daowen.entity.Huiyuan;
import com.daowen.vo.GuanzhuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daowen.mapper.HuiyuanMapper;
import com.daowen.ssm.simplecrud.SimpleBizservice;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;

@Service("huiyuanService")
public class HuiyuanService extends SimpleBizservice<HuiyuanMapper> {


    @Autowired
    private HuiyuanMapper huiyuanMapper;


    public int  deduct(int  hyId,double fee){
        if(hyId<=0)
            return -1;
        Huiyuan huiyuan=load("where id="+hyId);
        if(huiyuan==null)
            return -2;
        if(huiyuan.getYue()<fee)
            return -3;
        int count=this.executeUpdate(MessageFormat.format(" update huiyuan set yue=yue-{0,number,#} where id={1,number,#} ",fee,hyId));
        return count;

    }


    public  List<Huiyuan>   getEntityPlus(HashMap map){
        return  huiyuanMapper.getEntityPlus(map);
    }

    public  Huiyuan   loadPlus(HashMap map){
        return huiyuanMapper.loadPlus(map);
    }

    public  Huiyuan   loadPlus(int id){
        HashMap map = new HashMap();
        map.put("id",id);
        return this.loadPlus(map);
    }

}
