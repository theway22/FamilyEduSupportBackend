package com.daowen.entity;

import java.util.Date;

import javax.persistence.*;

/**
 * 留言
 */

public class Leaveword {


    //编码
    private int id;

    //内容
    private String dcontent;

    //发布时间
    private Date pubtime;

    //咨询人
    private int sendorid;

    //回复时间
    private Date replytime;

    //回复人
    private String replyren;

    //回复
    private String replycontent;

    //状态
    private int state;

    private  int   targetid;

    public int getSendorid() {
        return sendorid;
    }

    public void setSendorid(int sendorid) {
        this.sendorid = sendorid;
    }

    public int getTargetid() {
        return targetid;
    }

    public void setTargetid(int targetid) {
        this.targetid = targetid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDcontent() {
        return dcontent;
    }

    public void setDcontent(String dcontent) {
        this.dcontent = dcontent;
    }

    public Date getPubtime() {
        return pubtime;
    }

    public void setPubtime(Date pubtime) {
        this.pubtime = pubtime;
    }



    public Date getReplytime() {
        return replytime;
    }

    public void setReplytime(Date replytime) {
        this.replytime = replytime;
    }

    public String getReplyren() {
        return replyren;
    }

    public void setReplyren(String replyren) {
        this.replyren = replyren;
    }

    public String getReplycontent() {
        return replycontent;
    }

    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}