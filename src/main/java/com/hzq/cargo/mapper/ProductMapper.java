package com.hzq.cargo.mapper;

import com.hzq.cargo.entities.Product;
import com.hzq.cargo.util.PageUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-08-12 10:04
 */
@Mapper
public interface ProductMapper {
    PageUtil<Product> selectList(int start, int size);
    PageUtil<Product> selectListByName(@Param("start")int start, @Param("size") int size, @Param("name") String name);
    PageUtil<Product> selectListByDescription(@Param("start") int start, @Param("size") int size, @Param("description") String description);
    Product selectById(Long id);
    int insertProduct(Product product);
    int updateProduct(Product product);
    int deleteProduct(Long id);
    int updateStatus(Long id);
}
