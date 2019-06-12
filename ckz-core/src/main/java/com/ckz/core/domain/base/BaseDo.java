package com.ckz.core.domain.base;

import java.util.Date;

/**
 * @author
 * @version V1.0
 * @Title: works
 * @Package com.ald.bubble.domain.base
 * @Description: 基础DO
 * @date 2017/12/11 14:26
 */
public class BaseDo {

    private static final long serialVersionUID = 7374516668261890409L;

    private Integer isDelete;

    private String creater;

    private String modifier;

    private Date createTime;

    private Date modifyTime;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
