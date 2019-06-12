package com.ckz.core.domain.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author: caikaizhen
 * @date: 2019/2/25 17:52
 * @Description:
 */
@ApiModel(value="PageBaseReq",description="分页基类")
@Data
public class PageBaseReq {

    @ApiModelProperty(value="当前页", example = "1",required = true)
    @NotNull(message = "当前页不能为空")
    protected Integer currentPage;

    @ApiModelProperty(value="每页数量", example = "20",required = true)
    @NotNull(message = "每页数量不能为空")
    protected Integer pageSize;
}
