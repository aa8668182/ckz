package com.ckz.core.config;


import com.ckz.core.common.ApiResponse;
import com.ckz.core.common.MpExceptionCode;
import com.ckz.core.exception.AsyncException;
import com.ckz.core.exception.TokenNullException;
import io.jsonwebtoken.SignatureException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintDeclarationException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: caikaizhen
 * @date: 2019/2/21 18:18
 * @Description:
 */
@ControllerAdvice
@ResponseBody
@Slf4j
@Order(2)
public class GlobalExceptionHandler {


    @ExceptionHandler(value = NoHandlerFoundException.class)
    public Object NoHandlerFoundException(NoHandlerFoundException e) {
        log.error(e.toString());
        ApiResponse<String> apiResponse = new ApiResponse().setMpExceptionCode(MpExceptionCode.NO_HANDLER_FOUND);
        return apiResponse;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Object MethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        //按需重新封装需要返回的错误信息
        List<ParamValidationResult> paramValidationResults = new ArrayList<>();
        //解析原错误信息，封装后返回，此处返回非法的字段名称，错误信息
        for (ObjectError error : exception.getBindingResult().getAllErrors()) {
            ParamValidationResult validationResult = new ParamValidationResult();
            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                validationResult.setMessage(fieldError.getDefaultMessage());
                validationResult.setParam(fieldError.getField());
            } else {
                validationResult.setMessage(error.getDefaultMessage());
                validationResult.setMessage(error.getObjectName());
            }
            paramValidationResults.add(validationResult);
        }

        String logMessage = paramValidationResults
                .stream()
                .map(p -> "Field:" + p.getParam() + "  | " + "Message:" + p.getMessage())
                .collect(Collectors.joining(" | ", "MethodArgumentNotValidException: ", ""));
        log.info(logMessage);

        ApiResponse<List<ParamValidationResult>> apiResponse = new ApiResponse().setMpExceptionCode(MpExceptionCode.PARAM_ERROR);
        apiResponse.setMsg(exception.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        apiResponse.setData(paramValidationResults);
        return apiResponse;
    }

    @ExceptionHandler(ConstraintDeclarationException.class)
    public Object ConstraintDeclarationException(ConstraintDeclarationException e) {
        log.error(e.toString());
        ApiResponse<String> apiResponse = new ApiResponse().setMpExceptionCode(MpExceptionCode.PARAM_ERROR);
        return apiResponse;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Object httpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error(e.toString());
        ApiResponse<String> apiResponse = new ApiResponse().setMpExceptionCode(MpExceptionCode.PARAM_ERROR);
        apiResponse.setMsg("参数结构异常，请检查后重试");
        return apiResponse;
    }


    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Object HttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        log.error(e.toString());
        ApiResponse<String> apiResponse = new ApiResponse().setMpExceptionCode(MpExceptionCode.PARAM_ERROR);
        apiResponse.setMsg("媒体数据异常，请选择application/json提交");
        return apiResponse;
    }

    @ExceptionHandler(Exception.class)
    public Object GlobalException(Exception e) {
        log.error(e.toString());
        ApiResponse<String> apiResponse = new ApiResponse().setMpExceptionCode(MpExceptionCode.SYSTEM_ERROR);
        if (e instanceof TokenNullException || e instanceof SignatureException) {
            apiResponse = new ApiResponse().setMpExceptionCode(MpExceptionCode.TOKEN_IS_NULL);
        }
        if (e instanceof AsyncException) {
            AsyncException asyncException = (AsyncException) e;
            apiResponse = new ApiResponse().setMpExceptionCode(MpExceptionCode.ASYNC_EXCEPTION);
        }
        return apiResponse;
    }

    /**
     * 用于返回页面错误信息
     */
    @Data
    class ParamValidationResult {
        public String message;
        public String param;
    }
}
