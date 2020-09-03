package com.hzq.cargo.entities;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-08-24 9:15
 */
@Data
@ToString(callSuper = true)
public class Domain {
    //主键
    @TableId
    @JsonSerialize(using = ToStringSerializer.class)
    protected Long id;

    //创建时间
    @TableField(value = "create_date",fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime createDate;

    //最后更新时间
    @TableField(value = "last_update_date",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime lastUpdateDate;

    //备注信息
    @TableField("note")
    private String note;

    //版本号
    @TableField(fill = FieldFill.INSERT)
    @Version
    protected Integer version;
}

