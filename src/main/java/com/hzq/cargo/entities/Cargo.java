package com.hzq.cargo.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-08-24 9:18
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class Cargo extends Domain{
    @TableField("name")
    private String name;
    @TableField("price")
    private BigDecimal price;
    @TableField("inventory")
    private Long inventory;
    @TableField("note")
    private String note;
}
