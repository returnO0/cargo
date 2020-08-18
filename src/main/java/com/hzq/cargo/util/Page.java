package com.hzq.cargo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-08-14 15:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> {
    private List<T> records;
    private Long total;
}
