package com.hzq.cargo.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-08-24 9:18
 */
@Data
@ToString(callSuper = true)
public class Cargo extends Domain{
    @TableField("name")
    private String name;
    private BigDecimal price;
    private Long inventory;
    private String note;
}
