package com.ckz.core.common;

import com.ckz.core.utils.NullSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: caikaizhen
 * @date: 2019/2/18 14:20
 * @Description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value="ApiResponse",description="全局统一返回对象")
public class ApiResponse<T> {

    @ApiModelProperty(value="全局统一返回code(成功:1000,失败：1001)")
    private int code=1000;
    @ApiModelProperty(value="返回消息")
    private String msg;
    @ApiModelProperty(value="返回对象")
    @JsonSerialize(nullsUsing= NullSerialize.class)
    private T data;

    public  ApiResponse<T> setMpExceptionCode(MpExceptionCode excCode) {
        this.setCode(excCode.getErrorCode());
        this.setMsg(excCode.getDesc());
        return this;
    }

    public ApiResponse<T> setOk(T data) {
        ApiResponse<T> apiResponse = this.setMpExceptionCode(MpExceptionCode.SUCCESS);
        apiResponse.setData(data);
        return apiResponse;
    }

    public ApiResponse<T> setFailed(T data) {
        return this.setError(MpExceptionCode.FAILED,data);
    }
    public ApiResponse<T> setParamError(T data) {
        return this.setError(MpExceptionCode.PARAM_ERROR,data);
    }

    public ApiResponse<T> setError(MpExceptionCode excCode,T data) {
        ApiResponse<T> apiResponse = this.setMpExceptionCode(excCode);
        apiResponse.setData(data);
        return apiResponse;
    }
}
