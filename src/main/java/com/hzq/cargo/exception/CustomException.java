package com.hzq.cargo.exception;

import com.hzq.cargo.util.ResultCode;
import lombok.Getter;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-07-31 14:46
 */
@Getter
public class CustomException extends RuntimeException{
    ResultCode resultCode;
    public CustomException(ResultCode resultCode){
        this.resultCode=resultCode;
    }
}
