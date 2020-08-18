package com.hzq.cargo.util;

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
public class ResponseResult<T>{
    private boolean success;
    private int code;
    private String message;
    private T data;
    private Long total;

    public ResponseResult(ResultCode status) {
        this.success = status.success();
        this.code=status.code();
        this.message=status.message();
    }

    public ResponseResult(ResultCode status, T data) {
        this.success = status.success();
        this.code=status.code();
        this.message=status.message();
        this.data = data;
    }

    public ResponseResult(ResultCode status, T data, Long total) {
        this.success = status.success();
        this.code=status.code();
        this.message=status.message();
        this.data = data;
        this.total=total;
    }
}
