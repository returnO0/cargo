package com.hzq.cargo.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description 顾客记录表
 * @date 2020-09-02 14:45
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class Customer extends Domain{
    //顾客名称
    @TableField("name")
    private String name;
    //顾客性别
    @TableField("sex")
    private boolean sex;
    //地址
    @TableField("address")
    private String address;
    //联系方式
    @TableField("telephone")
    private String telephone;
    //身份证号
    @TableField("card_number")
    private String cardNumber;
}
