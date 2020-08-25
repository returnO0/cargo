package com.hzq.cargo.entities;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    @TableId
    protected Long id;

    @TableField(value = "create_date",fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime createDate;

    @TableField(value = "last_update_date",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime lastUpdateDate;

    @TableField(fill = FieldFill.INSERT)
    @Version
    protected Integer version;
}

