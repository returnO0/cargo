package com.hzq.cargo.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;

import java.util.List;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-08-14 15:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageUtil<T> {
    private List<T> records;
    private Long total;

    public static <T> Page<T> getPage(Pageable pageable) {
        return new Page<>(pageable.getPageNumber() + 1, pageable.getPageSize());
    }

    public static Long getTotal(Page<?> page) {
        return page.getTotal();
    }
}
