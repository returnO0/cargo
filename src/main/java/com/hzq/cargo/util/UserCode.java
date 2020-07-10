package com.hzq.cargo.util;

import lombok.ToString;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-07-10 09:32
 */
@ToString
public enum  UserCode implements ResultCode{
    USERNAME_OR_PASSWORD_ERROR(false,20001,"用户名或密码错误"),
    USER_EXIST(false,20002,"用户已经存在"),
    USER_NOT_EXIST(false,20003,"用户不存在");
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    UserCode() {
    }

    UserCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
