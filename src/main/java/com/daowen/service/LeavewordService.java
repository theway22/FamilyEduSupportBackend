package com.daowen.service;

import com.daowen.vo.LeavewordVo;
import org.springframework.stereotype.Service;
import com.daowen.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.daowen.ssm.simplecrud.SimpleBizservice;

import java.util.*;

import com.daowen.entity.*;

@Service
public class LeavewordService extends SimpleBizservice<LeavewordMapper> {

    @Autowired
    private LeavewordMapper leavewordMapper;


    public List<LeavewordVo> getEntityPlus(Map map) {
        return leavewordMapper.getEntityPlus(map);
    }

    public LeavewordVo loadPlus(Map map) {
        return leavewordMapper.loadPlus(map);
    }

    public LeavewordVo loadPlus(int id) {
        HashMap map = new HashMap();
        map.put("id", id);
        return leavewordMapper.loadPlus(map);
    }

    public List<Huiyuan> sendors(Map map){
        return leavewordMapper.sendors(map);
    }
    public List<Teacher> targets(Map map){
        return leavewordMapper.targets(map);
    }


}