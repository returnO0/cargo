package com.hzq.cargo.service;

import com.hzq.cargo.dao.ProductMapper;
import com.hzq.cargo.entities.Product;
import com.hzq.cargo.exception.ExceptionCast;
import com.hzq.cargo.util.SqlCode;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-08-12 10:05
 */
@Service
public class ProductService {
    @Resource
    private ProductMapper productMapper;

    /**
     * 查询全部商品列表
     * @return 商品列表
     */
    public List<Product> selectList(){
        return productMapper.selectList();
    }


    /**
     * 根据名称查找商品
     * @param name 商品名称
     * @return 商品列表
     */
    public List<Product> selectListByName(String name){
        if (StringUtils.isEmpty(name)){
            ExceptionCast.cast(SqlCode.PARAMS_IS_NULL);
        }
        return productMapper.selectListByName(name);
    }

    /**
     * 根据描述查找商品
     * @param description 商品描述
     * @return 商品列表
     */
    public List<Product> selectListByDescription(String description){
        if (StringUtils.isEmpty(description)){
            ExceptionCast.cast(SqlCode.PARAMS_IS_NULL);
        }
        return productMapper.selectListByDescription(description);
    }

    /**
     * 根据id查询商品详情
     * @param id 主键
     * @return 商品
     */
    public Product selectById(Long id){
        if (StringUtils.isEmpty(id)){
            ExceptionCast.cast(SqlCode.PARAMS_IS_NULL);
        }
        return productMapper.selectById(id);
    }

    /**
     * 保存商品
     * @param product 商品
     * @return 商品
     */
    public Product insertProduct(Product product){
        int i = productMapper.insertProduct(product);
        if (i<1){
            ExceptionCast.cast(SqlCode.SAVE_FAIL);
        }
        return product;
    }

    /**
     * 更新商品
     * @param product 商品
     * @return 商品
     */
    public Product updateProduct(Product product){
        int i = productMapper.updateProduct(product);
        if (i<1){
            ExceptionCast.cast(SqlCode.SAVE_FAIL);
        }
        return product;
    }

    /**
     * 根据删除
     * @param id 主键
     */
    public void deleteProduct(Long id){
        int i = productMapper.deleteProduct(id);
        if (i<1){
            ExceptionCast.cast(SqlCode.DELETE_FAIL);
        }
    }
}
