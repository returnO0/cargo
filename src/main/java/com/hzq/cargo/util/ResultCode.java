package com.hzq.cargo.util;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-07-10 09:19
 */
public interface ResultCode {
    //是否成功
    boolean success();
    //状态码
    int code();
    //提示信息
    String message();
}
