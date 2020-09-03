package com.hzq.cargo.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description 货物信息表
 * @date 2020-08-24 9:18
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class Cargo extends Domain{
    //货物名称
    @TableField("name")
    private String name;
    //货物价格
    @TableField("price")
    private BigDecimal price;
    //货物库存
    @TableField("inventory")
    private Long inventory;

}
