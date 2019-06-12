package com.ckz.core.common;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: caikaizhen
 * @date: 2019/2/18 16:44
 * @Description:
 */
@Data
@ApiModel
public class BaseEntity implements Serializable {

    //private static final long serialVersionUID = 1L;

    /*//当前页
    @TableField(exist = false)
    @ApiModelProperty(value = "当前页")
    private Integer page = 1;

    //页大小
    @TableField(exist = false)
    @ApiModelProperty(value = "页大小")
    private Integer limit = 10;

    *//**
     * 起始数据
     *//*
    @TableField(exist = false)
    @ApiModelProperty(value = "起始数据")
    private Integer beginIndex = 0;

    public Integer getBeginIndex(){

        if(page != null && limit != null)
            return page *limit - limit;
        else
            return 0;
    }*/

    /**
     * 暂时先放这里
     */
    public interface select{}
    public interface insert{}
    public interface update{}
    public interface delete{}
}
