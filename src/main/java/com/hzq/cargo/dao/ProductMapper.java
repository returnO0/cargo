package com.hzq.cargo.dao;

import com.hzq.cargo.entities.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-08-12 10:04
 */
@Mapper
public interface ProductMapper {
    List<Product> selectList();
    List<Product> selectListByName(String name);
    List<Product> selectListByDescription(String description);
    Product selectById(Long id);
    int insertProduct(Product product);
    int updateProduct(Product product);
    int deleteProduct(Long id);
}
