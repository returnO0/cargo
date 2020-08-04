package com.hzq.cargo.util;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-08-04 15:48
 */
@NoArgsConstructor
@AllArgsConstructor
public enum  ProductCategoryCode implements ResultCode {
    PRODUCTCATEGORY_EXIST(false,30001,"该商品名称重复");
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

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
