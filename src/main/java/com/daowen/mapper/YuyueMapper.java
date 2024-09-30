package com.daowen.mapper;
import com.daowen.entity.*;
import com.daowen.ssm.simplecrud.SimpleMapper;
import org.springframework.stereotype.Repository;
import java.util.*;
/*
*  预约
**/
@Repository
public interface YuyueMapper  extends SimpleMapper<Yuyue> {

          List<Yuyue>   getEntityPlus(HashMap map);
          
           Yuyue   loadPlus(HashMap map);

}