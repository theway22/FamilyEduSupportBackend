package com.daowen.service;
import org.springframework.stereotype.Service;
import com.daowen.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.daowen.ssm.simplecrud.SimpleBizservice;
import java.util.*;
import com.daowen.entity.*;

@Service
public   class  StagService extends  SimpleBizservice<StagMapper>{

      @Autowired
      private  StagMapper  stagMapper;


       public List< Stag> getEntityPlus(Map map){
          return  stagMapper.getEntityPlus(map);
      }

      public  Stag   loadPlus(Map map ){
            return  stagMapper.loadPlus(map);
      }
      
     public  Stag   loadPlus(int id ){
             HashMap map=new HashMap();
             map.put("id",id);
            return  stagMapper.loadPlus(map);
      }


     
}