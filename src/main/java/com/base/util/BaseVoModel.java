package com.base.util;

/**
 * @author zjd
 */
public class BaseVoModel {
    private String id;


    private String isdel;


    private String isdelPer;


    private String createTime;


    private String updateTime;


    private String rowid;


    public String getId() {

        return this.id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getIsdel() {

        return this.isdel;
    }

    public void setIsdel(String isdel) {

        this.isdel = isdel;
    }

    public String getIsdelPer() {

        return this.isdelPer;
    }

    public void setIsdelPer(String isdelPer) {

        this.isdelPer = isdelPer;
    }

    public String getCreateTime() {

        return this.createTime;
    }

    public void setCreateTime(String createTime) {

        this.createTime = createTime;
    }

    public String getUpdateTime() {

        return this.updateTime;
    }

    public void setUpdateTime(String updateTime) {

        this.updateTime = updateTime;
    }

    public String getRowid() {

        return this.rowid;
    }

    public void setRowid(String rowid) {

        this.rowid = rowid;
    }
}

