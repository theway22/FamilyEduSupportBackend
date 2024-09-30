package com.daowen.service;
import com.daowen.entity.Huiyuan;
import com.daowen.vo.GuanzhuVo;
import org.springframework.stereotype.Service;
import com.daowen.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.daowen.ssm.simplecrud.SimpleBizservice;

import java.util.List;

@Service
public   class  FansService extends  SimpleBizservice<FansMapper>{

      @Autowired
      private  FansMapper  fansMapper;


      public List<GuanzhuVo> getStars(int id){
        return fansMapper.getStars(id);
      }


    public List<Huiyuan> getFans(int tid){
        return fansMapper.getFans(tid);
    }



}