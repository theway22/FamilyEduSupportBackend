package com.daowen.service;

import com.daowen.entity.Lanmu;
import com.daowen.vo.ImageTextItem;
import com.daowen.vo.LanmuContentVo;
import com.daowen.vo.LanmuVo;

import java.util.List;

public interface ILanmuAdapter {

    /**
     * 定义编码
     */
      int getDefineCode();

    /**
     * 获取板块内容
     * @param lanmu
     * @return
     */
    LanmuContentVo<ImageTextItem> getLanmuContent(Lanmu lanmu);



    List<LanmuVo>  getMyLanmus();



}
