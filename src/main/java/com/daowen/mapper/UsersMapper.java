package com.daowen.mapper;

import java.util.List;
import java.util.Map;

import com.daowen.entity.Huiyuan;
import com.daowen.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import com.daowen.ssm.simplecrud.SimpleMapper;
@Mapper
public interface UsersMapper extends SimpleMapper<Users> {

	List<Users> getEntityPlus(Map map);

	Users  loadPlus(Map map);


    List<Huiyuan> getFans(Integer id);
}
