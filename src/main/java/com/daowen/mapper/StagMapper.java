package com.daowen.mapper;
import com.daowen.entity.*;
import com.daowen.ssm.simplecrud.SimpleMapper;
import org.springframework.stereotype.Repository;
import java.util.*;
/*
*  标签
**/
@Repository
public interface StagMapper  extends SimpleMapper<Stag> {

          List<Stag>   getEntityPlus(Map map);
          
          Stag  loadPlus(Map map);
          
          

}