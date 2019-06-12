package com.ckz.core.domain.base;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author: caikaizhen
 * @date: 2019/2/25 20:33
 * @Description:
 */
@ApiModel(value="PageBaseResp",description="分页返回数据基类")
@Data
public class PageBaseResp<T> {

    @ApiModelProperty(value="总页数", example = "50")
    private Integer pages;

    @ApiModelProperty(value="总条数", example = "1000")
    private Long total;

    @ApiModelProperty(value="当前页", example = "1")
    private Integer currentPage;

    @ApiModelProperty(value="每页数量", example = "20")
    private Integer pageSize;

    private List<T> list;

    public PageBaseResp(PageInfo info) {
        this.pages = info.getPages();
        this.total = info.getTotal();
        this.currentPage = info.getPageNum();
        this.pageSize = info.getPageSize();
        this.list = info.getList();
    }


    public PageBaseResp(Page info) {
        this.pages = info.getPages();
        this.total = info.getTotal();
        this.currentPage = info.getPageNum();
        this.pageSize = info.getPageSize();
        this.list = info.getResult();
    }
}
