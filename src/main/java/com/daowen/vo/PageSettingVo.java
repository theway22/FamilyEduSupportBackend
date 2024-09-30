package com.daowen.vo;

import java.util.List;

/**
 * 页面板块设置
 */
public class PageSettingVo {

    /**
     * 页面编号
     */
    private int pageId;

    /**
     * 页面名称
     */
    private String pageName;

    /**
     * 板块项
     */
    private List<PsItemVo> psItemVos;


    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public List<PsItemVo> getPsItemVos() {
        return psItemVos;
    }

    public void setPsItemVos(List<PsItemVo> psItemVos) {
        this.psItemVos = psItemVos;
    }


}
