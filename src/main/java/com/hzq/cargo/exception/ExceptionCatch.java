package com.hzq.cargo.exception;

import com.google.common.collect.ImmutableMap;
import com.hzq.cargo.util.CommonCode;
import com.hzq.cargo.util.ResponseResult;
import com.hzq.cargo.util.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-07-31 14:53
 */
@ControllerAdvice   //控制器增强
public class ExceptionCatch {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);
    //定义map,配置异常类型所对应的错误代码
    private static ImmutableMap<Class<? extends Throwable>,ResultCode> EXCEPTIONS;
    //定义map的builder对象,去构建ImmutableMap
    private static ImmutableMap.Builder<Class<? extends Throwable>,ResultCode> builder=ImmutableMap.builder();
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseResult customException(CustomException customException){
        ResultCode resultCode = customException.getResultCode();
        LOGGER.error("捕获到一个异常:{}",resultCode.message());
        return new ResponseResult(resultCode);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult Exception(Exception exception){
        LOGGER.error("捕获到一个异常:{}",exception.getMessage());
        if (EXCEPTIONS==null){
            EXCEPTIONS=builder.build();
        }
        ResultCode resultCode = EXCEPTIONS.get(exception.getClass());
        if (resultCode!=null){
            return new ResponseResult(resultCode);
        }else {
            return new ResponseResult(CommonCode.SERVER_ERROR);
        }
        //从EXCEPTIONS中找异常类型对应的错误代码,如果找不到统一返回 服务器异常,请联系管理员
    }

    static {
        builder.put(HttpMessageNotReadableException.class,CommonCode.INVALID);
        builder.put(HttpRequestMethodNotSupportedException.class,CommonCode.REQUEST_METHOD_ERROR);
    }
}
