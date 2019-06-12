package com.ckz.core.exception;


/** 抛出异步异常
 * @author: caikaizhen
 * @date: 2019/3/15 17:21
 * @Description:
 */
public class AsyncException extends RuntimeException{

    public AsyncException(Throwable cause) {
        super(cause);
    }
}
