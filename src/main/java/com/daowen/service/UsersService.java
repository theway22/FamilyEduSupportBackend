package com.daowen.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.daowen.entity.Huiyuan;
import com.daowen.entity.Users;
import com.daowen.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daowen.ssm.simplecrud.SimpleBizservice;

@Service
public class UsersService extends SimpleBizservice<UsersMapper> {

    @Autowired
    private UsersMapper  mapper;
	public List<Users> getEntityPlus(Map map){
	    return mapper.getEntityPlus(map);
    }

    public Users  loadPlus(Map map){

	    return mapper.loadPlus(map);
    }
    public Users loadPlus(int id){
        HashMap map=new HashMap();
        map.put("id",id);
        return this.loadPlus(map);
    }

    public List<Huiyuan> getFans(Integer id) {
	   return mapper.getFans(id);
    }
}
