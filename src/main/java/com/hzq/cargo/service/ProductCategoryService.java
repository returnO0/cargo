package com.hzq.cargo.service;

import com.hzq.cargo.mapper.ProductCategoryMapper;
import com.hzq.cargo.dto.CategoryDTO;
import com.hzq.cargo.entities.ProductCategory;
import com.hzq.cargo.exception.ExceptionCast;
import com.hzq.cargo.util.ProductCategoryCode;
import com.hzq.cargo.util.SqlCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-07-31 11:10
 */
@Service
public class ProductCategoryService {
    @Resource
    ProductCategoryMapper productCategoryMapper;

    /**
     * 根据父id获取商品类型列表 id=0表示没有父类别
     * @param parentId 父类别id
     * @return 商品类型列表
     */
    public List<ProductCategory> getProductCategoryList(Integer parentId){
        if (parentId==null){
            ExceptionCast.cast(SqlCode.PARAMS_IS_NULL);
        }
        return productCategoryMapper.getProductCategoryListByParentId(parentId);
    }

    /**
     * 插入新的商品类型
     * @param productCategory 商品类型实体类
     */
    public void insertProductCategory(ProductCategory productCategory){
        if (productCategory==null){
            ExceptionCast.cast(SqlCode.PARAMS_IS_NULL);
        }
        if (productCategory.getParentId()==null){
            productCategory.setParentId(Long.parseLong("0"));
        }
        Boolean exist = this.productExistByName(productCategory.getCategoryName());
        if (exist){
            ExceptionCast.cast(ProductCategoryCode.PRODUCTCATEGORY_EXIST);
        }
        int i = productCategoryMapper.insertProductCategory(productCategory);
        if (i<1){
            ExceptionCast.cast(SqlCode.SAVE_FAIL);
        }
    }

    /**
     * 更新商品类型
     * @param productCategory 商品类型实体类
     */
    public void updateProductCategory(ProductCategory productCategory){
        int i = productCategoryMapper.updateProductCategory(productCategory);
        if (i<1){
            ExceptionCast.cast(SqlCode.SAVE_FAIL);
        }
    }

    /**
     * 根据id删除商品类别
     * @param id 商品id
     */
    public void deleteProductCategoryById(int id){
        int i = productCategoryMapper.deleteProductCategoryById(id);
        if (i<1){
            ExceptionCast.cast(SqlCode.DELETE_FAIL);
        }
    }

    /**
     * 通过商品类别名称判断类别是否存在
     * @param categoryName  商品名称
     * @return 是否存在
     */
    private Boolean productExistByName(String categoryName){
        int i = productCategoryMapper.productExistByName(categoryName);
        return i>0;
    }

    /**
     * @param id 主键
     * @return  类别名和父类别名
     */

    public CategoryDTO selectCategoryNameAndParentNameById(Long id){
        return productCategoryMapper.selectCategoryNameAndParentNameById(id);
    }
}
