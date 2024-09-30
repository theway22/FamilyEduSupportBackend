package com.daowen.vo;

import com.daowen.entity.Sysconfig;
import com.daowen.entity.Sysconfigitem;

import java.util.Iterator;
import java.util.List;

public class SysconfigVo extends Sysconfig {

    private List<Sysconfigitem> cfgitems;

    public List<Sysconfigitem> getCfgitems() {
        if(cfgitems!=null){
            Iterator<Sysconfigitem> iterator = cfgitems.iterator();
            while(iterator.hasNext()){
                Sysconfigitem sysconfigitem=iterator.next();
                if(sysconfigitem.getId()==0)
                    iterator.remove();
            }
        }
        return cfgitems;
    }
    public void setCfgitems(List<Sysconfigitem> cfgitems) {
        this.cfgitems = cfgitems;
    }
}
