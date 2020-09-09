package com.hzq.cargo.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import java.math.BigDecimal;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description 交易记录表
 * @date 2020-09-02 14:28
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class Transaction extends Domain{
    //交易货物编号
    @TableField("cargo_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long cargoId;
    //交易人id
    @TableField("user_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    //交易单价
    @TableField("unit_price")
    private BigDecimal unitPrice;
    //交易数量
    @TableField("trading_volume")
    private Integer tradingVolume;
    //交易总金额
    @TableField("amount")
    private BigDecimal amount;
    //进货/出货 true/false
    @TableField("status")
    private Boolean status;
}
