package com.hzq.cargo.dto;

import lombok.Data;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-08-18 9:32
 */
@Data
public class CategoryDTO {
    private String categoryName;        // 类别名称
    private String parentName;  // 父类别名称
}
