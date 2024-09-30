package com.daowen.mapper;
import com.daowen.entity.*;
import com.daowen.ssm.simplecrud.SimpleMapper;
import org.springframework.stereotype.Repository;
import java.util.*;
/*
*  教育指导师
**/
@Repository
public interface TeacherMapper  extends SimpleMapper<Teacher> {

          List<Teacher>   getEntityPlus(HashMap map);
          
           Teacher   loadPlus(HashMap map);

           List<Teacher> getMyteacher(HashMap map);

}