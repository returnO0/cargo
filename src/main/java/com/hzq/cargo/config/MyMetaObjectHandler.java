package com.hzq.cargo.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.hzq.cargo.exception.ExceptionCast;
import com.hzq.cargo.util.SqlCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-08-24 9:21
 */
@Slf4j
@Component
// 1.实现MetaObjectHandler的insertFill和updateFill
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        //this.setFieldValByName(String filedName,Object fieldVal,MetaObject metaObject)
        //
        this.setFieldValByName("createDate", LocalDateTime.now(),metaObject);
        this.setFieldValByName("version",1,metaObject);
        this.setFieldValByName("lastUpdateDate", LocalDateTime.now(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object version = this.getFieldValByName("version", metaObject);
        if (version==null){
            ExceptionCast.cast(SqlCode.VERSION_NULL);
        }
        this.setFieldValByName("lastUpdateDate", LocalDateTime.now(),metaObject);
    }

}