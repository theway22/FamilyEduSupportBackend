package com.daowen.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import javax.persistence.*;

/**
 * 健身订单
 */
@Entity
public class Appointorder {


    //编码

    @Id
    private int id;


    //订单编号

    private String ddno;


    //预定日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date yydate;


    //金额（元）

    private Double fee;


    //缴费人

    private int hyid;


    //联系电话

    private String mobile;


    //状态

    private int state;


    //缴费目标

    private int targetid;

    @Transient
    private String hyaccount;

    @Transient
    private String hyname;
    @Transient
    private String pname;


    private int count;

    private double danjia;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getDanjia() {
        return danjia;
    }

    public void setDanjia(double danjia) {
        this.danjia = danjia;
    }

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

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    //说明

    private String des;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDdno() {
        return ddno;
    }

    public void setDdno(String ddno) {
        this.ddno = ddno;
    }

    public Date getYydate() {
        return yydate;
    }

    public void setYydate(Date yydate) {
        this.yydate = yydate;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getHyid() {
        return hyid;
    }

    public void setHyid(int hyid) {
        this.hyid = hyid;
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

    public int getTargetid() {
        return targetid;
    }

    public void setTargetid(int targetid) {
        this.targetid = targetid;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

}