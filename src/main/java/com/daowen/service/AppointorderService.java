package com.daowen.service;

import com.daowen.entity.*;
import org.springframework.stereotype.Service;
import com.daowen.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.daowen.ssm.simplecrud.SimpleBizservice;

import java.util.HashMap;
import java.util.List;

@Service
public class AppointorderService extends SimpleBizservice<AppointorderMapper> {

    @Autowired
    private AppointorderMapper appointorderMapper;


    public List<Appointorder> getEntityPlus(HashMap map) {
        return appointorderMapper.getEntityPlus(map);
    }

    public Appointorder loadPlus(HashMap map) {
        return appointorderMapper.loadPlus(map);
    }

    public Appointorder loadPlus(int id) {
        HashMap map = new HashMap();
        map.put("id", id);
        return this.loadPlus(map);
    }

}