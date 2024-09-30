package com.daowen.service;
import com.daowen.entity.*;
import org.springframework.stereotype.Service;
import com.daowen.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.daowen.ssm.simplecrud.SimpleBizservice;

import java.util.HashMap;
import java.util.List;
@Service
public   class  TeacherService extends  SimpleBizservice<TeacherMapper>{

      @Autowired
      private  TeacherMapper  teacherMapper;



          public  List<Teacher>   getEntityPlus(HashMap map){
               return  teacherMapper.getEntityPlus(map);
          }
          
          public  Teacher   loadPlus(HashMap map){
              return teacherMapper.loadPlus(map);
          }
          
           public  Teacher   loadPlus(int id){
                 HashMap map = new HashMap();
	         map.put("id",id);
	        return this.loadPlus(map);
          }

           public List<Teacher> getMyteacher(HashMap map){
                return teacherMapper.getMyteacher(map);
            }
     
}