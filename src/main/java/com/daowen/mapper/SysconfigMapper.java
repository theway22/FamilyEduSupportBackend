package com.daowen.mapper;
import com.daowen.entity.Sysconfig;
import com.daowen.ssm.simplecrud.SimpleMapper;
import com.daowen.vo.SysconfigVo;

import java.util.List;
import java.util.Map;

public interface SysconfigMapper extends SimpleMapper<Sysconfig> {

    List<SysconfigVo> getEntityPlus(Map map);

    SysconfigVo loadPlus(Map map);
}
