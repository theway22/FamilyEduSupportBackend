package com.daowen.mapper;

import com.daowen.entity.Huiyuan;
import com.daowen.ssm.simplecrud.SimpleMapper;
import com.daowen.vo.GuanzhuVo;

import java.util.HashMap;
import java.util.List;

public interface HuiyuanMapper extends SimpleMapper<Huiyuan> {




    List<Huiyuan>   getEntityPlus(HashMap map);

    Huiyuan   loadPlus(HashMap map);

}
