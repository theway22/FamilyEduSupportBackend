package com.daowen.entity;

import java.util.Date;

import javax.persistence.*;

/**
 * 预约
 */
@Entity
public class Yuyue {


    //编码

    @Id
    private int id;


    //标题

    private String title;


    //预约日期

    private Date yydate;


    //电话

    private String mobile;


    //状态

    private int state;


    //预约人

    private int hyid;


    //目标编号

    private int targetid;


    //说明

    private String dcontent;

    @Transient
    private String hyaccount;
    @Transient
    private String hyname;

    @Transient
    private String taccount;
    @Transient
    private String tname;

    public String getHyaccount() {
        return hyaccount;
    }

    public void setHyaccount(String hyaccount) {
        this.hyaccount = hyaccount;
    }

    public String getHyname() {
        return hyname;
    }

    public void setHyname(String hyname) {
        this.hyname = hyname;
    }

    public String getTaccount() {
        return taccount;
    }

    public void setTaccount(String taccount) {
        this.taccount = taccount;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }


    //回复

    private String replydes;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getYydate() {
        return yydate;
    }

    public void setYydate(Date yydate) {
        this.yydate = yydate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getHyid() {
        return hyid;
    }

    public void setHyid(int hyid) {
        this.hyid = hyid;
    }

    public int getTargetid() {
        return targetid;
    }

    public void setTargetid(int targetid) {
        this.targetid = targetid;
    }

    public String getDcontent() {
        return dcontent;
    }

    public void setDcontent(String dcontent) {
        this.dcontent = dcontent;
    }

    public String getReplydes() {
        return replydes;
    }

    public void setReplydes(String replydes) {
        this.replydes = replydes;
    }

}