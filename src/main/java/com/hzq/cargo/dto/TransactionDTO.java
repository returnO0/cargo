package com.hzq.cargo.dto;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-09-02 20:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    //主键
    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    //交易货物编号
    @JsonSerialize(using = ToStringSerializer.class)
    private Long cargoId;
    //货物名称
    private String cargoName;
    //交易人id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    //交易人名称
    private String userName;
    //交易单价
    private BigDecimal unitPrice;
    //交易单价从
    private BigDecimal unitPriceFrom;
    //交易单价到
    private BigDecimal unitPriceTo;
    //交易数量从
    private Integer tradingVolumeFrom;
    //交易数量到
    private Integer tradingVolumeTo;
    //交易数量
    private Integer tradingVolume;
    //交易总金额从
    private BigDecimal amountFrom;
    //交易总金额从
    private BigDecimal amountTo;
    //交易总金额
    private BigDecimal amount;
    //进货/出货 true/false
    private Boolean status;
    //备注信息
    private String note;
    //交易时间从
    private String createDateFrom;
    //交易时间到
    private String createDateTo;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;
    //最后更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUpdateDate;
    //版本号
    private Integer version;
}
