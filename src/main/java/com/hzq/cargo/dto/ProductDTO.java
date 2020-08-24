package com.hzq.cargo.dto;

import lombok.Data;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-08-18 9:59
 */
@Data
public class ProductDTO {
    private Long id;        //id
    private String name;    //商品名称
    private String description; //描述
    private double price;   //价格
    private Long typeId;    //类别id
    private boolean status; //上架状态
    private String categoryName;        // 类别名称
    private String parentName;  // 父类别名称
    private Long parentTypeId; // 父类别id
}
