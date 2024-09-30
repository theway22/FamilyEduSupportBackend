package com.daowen.vo;

import java.util.Date;

public class ImageTextItem {

    private String name;

    private  String tupian;

    private String  abstact;

    private String pbrname;

    public String getPbrname() {
        return pbrname;
    }

    public void setPbrname(String pbrname) {
        this.pbrname = pbrname;
    }


    public String getAbstact() {
        return abstact;
    }

    public void setAbstact(String abstact) {
        this.abstact = abstact;
    }

    private  String href;

    private  double price;

    private Date  pubtime;

    private String tagname;

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public Date getPubtime() {
        return pubtime;
    }

    public void setPubtime(Date pubtime) {
        this.pubtime = pubtime;
    }

    private  int  clickCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTupian() {
        return tupian;
    }

    public void setTupian(String tupian) {
        this.tupian = tupian;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
