package com.hzq.cargo.service;

import com.hzq.cargo.mapper.ProductMapper;
import com.hzq.cargo.dto.CategoryDTO;
import com.hzq.cargo.dto.ProductDTO;
import com.hzq.cargo.entities.Product;
import com.hzq.cargo.exception.ExceptionCast;
import com.hzq.cargo.util.Page;
import com.hzq.cargo.util.SqlCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    @Autowired
    ProductCategoryService productCategoryService;

    /**
     * 查询全部商品列表
     * @return 商品列表
     * @param page 页数
     * @param size 每页个数
     */
    public Page<ProductDTO> selectList(int page, int size){
        int start = page*size;
        Page<Product> productPage = productMapper.selectList(start, size);
        if (productPage==null){
            return new Page<>();
        }
        return this.toProductDTO(productPage);
    }


    /**
     * 根据名称查找商品
     * @param name 商品名称
     * @return 商品列表
     */
    public Page<ProductDTO> selectListByName(int page, int size,String name){
        int start = page*size;
        if (StringUtils.isEmpty(name)){
            ExceptionCast.cast(SqlCode.PARAMS_IS_NULL);
        }
        Page<Product> productPage = productMapper.selectListByName(start, size, name);
        if (productPage==null){
            return new Page<>();
        }
        return this.toProductDTO(productPage);
    }

    /**
     * 根据描述查找商品
     * @param description 商品描述
     * @return 商品列表
     */
    public Page<ProductDTO> selectListByDescription(int page, int size,String description){
        int start = page*size;
        if (StringUtils.isEmpty(description)){
            ExceptionCast.cast(SqlCode.PARAMS_IS_NULL);
        }
        Page<Product> productPage = productMapper.selectListByDescription(start, size, description);
        if (productPage==null){
            return new Page<>();
        }
        return this.toProductDTO(productPage);
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


    /**
     * 商品类中添加字段
     * @param productPage 商品类page对象
     * @return DTO的page对象
     */
    private Page<ProductDTO> toProductDTO(Page<Product> productPage){
        Page<ProductDTO> page=new Page<>();
        List<Product> records = productPage.getRecords();
        List<ProductDTO> newRecords=new ArrayList<>();
        records.forEach(item->{
            ProductDTO productDTO=new ProductDTO();
            //复制原始值
            BeanUtils.copyProperties(item,productDTO);
            CategoryDTO categoryDTO = productCategoryService.selectCategoryNameAndParentNameById(item.getTypeId());
            //复制新增值
            BeanUtils.copyProperties(categoryDTO,productDTO);
            newRecords.add(productDTO);
        });
        page.setRecords(newRecords);
        page.setTotal(productPage.getTotal());
        return page;
    }


    /**
     * 修改商品上架状态
     * @param id 商品id
     */
    public void updateStatus(Long id){
        int i = productMapper.updateStatus(id);
        if (i<1){
            ExceptionCast.cast(SqlCode.SAVE_FAIL);
        }
    }
}
