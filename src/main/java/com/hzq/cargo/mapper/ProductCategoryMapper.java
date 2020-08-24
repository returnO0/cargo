package com.hzq.cargo.dao;

import com.hzq.cargo.dto.CategoryDTO;
import com.hzq.cargo.entities.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-07-31 10:17
 */
@Mapper
public interface ProductCategoryMapper {
    List<ProductCategory> getProductCategoryListByParentId(Integer parentId);
    int insertProductCategory(ProductCategory productCategory);
    int updateProductCategory(ProductCategory productCategory);
    int deleteProductCategoryById(int id);
    int productExistByName(String categoryName);
    CategoryDTO selectCategoryNameAndParentNameById(Long id);

}
