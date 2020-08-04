package com.hzq.cargo.exception;

import com.hzq.cargo.util.ResultCode;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-07-31 14:51
 */
public class ExceptionCast {
    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}
