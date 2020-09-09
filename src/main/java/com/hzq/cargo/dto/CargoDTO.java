package com.hzq.cargo.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-09-08 9:08
 */
@Data
public class CargoDTO {
    //货物名称
    private String name;
    //货物价格从
    private BigDecimal priceFrom;
    //货物价格到
    private BigDecimal priceTo;
    //货物库存从
    private Long inventoryFrom;
    //货物库存到
    private Long inventoryTo;
    //备注
    private String note;
}
