package com.daowen.vo;

import com.daowen.entity.Yingpian;
public class YingpianVo extends Yingpian {

    private String typename;

    private String subtypename;

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }


    public String getSubtypename() {
        return subtypename;
    }

    public void setSubtypename(String subtypename) {
        this.subtypename = subtypename;
    }
}
