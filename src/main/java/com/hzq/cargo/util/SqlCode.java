package com.hzq.cargo.util;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-08-03 11:00
 */
public enum  SqlCode implements ResultCode {
    PARAMS_IS_NULL(false,7001,"请求参数为空"),
    SAVE_FAIL(false,7002,"保存数据失败"),
    DELETE_FAIL(false,7003,"数据删除失败");
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private SqlCode(boolean success,int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }
    @Override
    public boolean success() {
        return false;
    }

    @Override
    public int code() {
        return 0;
    }

    @Override
    public String message() {
        return null;
    }
}
