package com.daowen.entity;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Sysconfigitem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String dcontent;

    public String getDcontent() {
        return dcontent;
    }

    public void setDcontent(String dcontent) {
        this.dcontent = dcontent;
    }

    private int cfgid;

    public int getCfgid() {
        return cfgid;
    }

    public void setCfgid(int cfgid) {
        this.cfgid = cfgid;
    }

    private int type;

    private String href;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
