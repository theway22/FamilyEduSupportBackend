package com.daowen.service;
import com.daowen.entity.*;
import org.springframework.stereotype.Service;
import com.daowen.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.daowen.ssm.simplecrud.SimpleBizservice;

import java.util.HashMap;
import java.util.List;
@Service
public   class  YuyueService extends  SimpleBizservice<YuyueMapper>{

      @Autowired
      private  YuyueMapper  yuyueMapper;



          public  List<Yuyue>   getEntityPlus(HashMap map){
               return  yuyueMapper.getEntityPlus(map);
          }
          
          public  Yuyue   loadPlus(HashMap map){
              return yuyueMapper.loadPlus(map);
          }
          
           public  Yuyue   loadPlus(int id){
                 HashMap map = new HashMap();
	         map.put("id",id);
	        return this.loadPlus(map);
          }
     
}