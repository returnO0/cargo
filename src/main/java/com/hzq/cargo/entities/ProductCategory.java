package com.hzq.cargo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-07-30 23:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory {
    private Long id;
    private Long parentId;
    private String categoryName;
}
