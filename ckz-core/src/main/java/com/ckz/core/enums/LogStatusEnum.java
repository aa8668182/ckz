package com.ckz.core.enums;

/**
 * @author: caikaizhen
 * @date: 2018/11/29 23:01
 * @Description:
 */
public enum LogStatusEnum {
        OPER_LOG_STATUS_SUCCESS(1),
        OPER_LOG_STATUS_FAIL(2);

        private int value;

        private LogStatusEnum(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

