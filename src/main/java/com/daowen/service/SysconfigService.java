package com.daowen.service;
import com.daowen.mapper.SysconfigMapper;
import com.daowen.ssm.simplecrud.SimpleBizservice;
import com.daowen.vo.SysconfigVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysconfigService extends SimpleBizservice<SysconfigMapper>{
    @Autowired
    private SysconfigMapper sysconfigMapper;
    public List<SysconfigVo> getEntityPlus(Map map){
        return  sysconfigMapper.getEntityPlus(map);
    }
    public SysconfigVo loadPlus(Map map){
        return sysconfigMapper.loadPlus(map);
    }
    public SysconfigVo loadPlus(int id){
        HashMap map =new HashMap();
        map.put("id",id);
        return this.loadPlus(map);
    }

}
