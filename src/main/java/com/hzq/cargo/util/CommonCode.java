package com.hzq.cargo.util;


import lombok.ToString;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description 返回状态枚举
 * @date 2020-07-09 16:24
 */
@ToString
public enum CommonCode implements ResultCode{
    INVALID(false,100003,"参数非法"),
    REQUEST_METHOD_ERROR(false,100004,"请求方法类型错误"),
    SUCCESS(true,10000,"操作成功！"),
    FAIL(false,11111,"操作失败！"),
    SERVER_FAIL(false,88888,"无法获取服务"),
    UNAUTHENTICATED(false,10001,"此操作需要登陆系统！"),
    UNAUTHORISE(false,10002,"权限不足，无权操作！"),
    SERVER_ERROR(false,99999,"服务器异常,请联系管理员");
    //    private static ImmutableMap<Integer, CommonCode> codes ;
    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private CommonCode(boolean success,int code, String message){
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

