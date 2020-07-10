package com.hzq.cargo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-07-09 16:23
 */
@Data
@NoArgsConstructor
@ToString
public class CommonResult<T>{
    boolean success;
    int code;
    String message;
    private T data;

    public CommonResult(ResultCode status, T data) {
        this.success = status.success();
        this.code=status.code();
        this.message=status.message();
        this.data = data;
    }
}
