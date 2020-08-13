package com.hzq.cargo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description 商品类
 * @date 2020-08-12 10:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String description;
    private double price;
    private boolean status;
}
