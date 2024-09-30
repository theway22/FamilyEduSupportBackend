package com.daowen.mapper;
import com.daowen.entity.Sysrole;
import com.daowen.ssm.simplecrud.SimpleMapper;
import org.springframework.stereotype.Repository;
import java.util.*;
/*
*  角色
**/
@Repository
public interface SysroleMapper  extends SimpleMapper<Sysrole> {

          List<Sysrole>   getEntityPlus(Map map);
          
          Sysrole  loadPlus(Map map);
          
          

}