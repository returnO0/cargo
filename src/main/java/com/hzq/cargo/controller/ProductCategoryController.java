package com.hzq.cargo.controller;

import com.hzq.cargo.entities.ProductCategory;
import com.hzq.cargo.service.ProductCategoryService;
import com.hzq.cargo.util.CommonCode;
import com.hzq.cargo.util.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-07-31 15:15
 */
@RestController
@RequestMapping("/api/productCategory")
public class ProductCategoryController {
    @Resource
    ProductCategoryService productCategoryService;

    @GetMapping("/{parentId}")
    public ResponseResult<List<ProductCategory>> getProductCategoryList(@PathVariable(value = "parentId",required = false) Integer parentId){
        List<ProductCategory> productCategoryList = productCategoryService.getProductCategoryList(parentId);
        return new ResponseResult<>(CommonCode.SUCCESS,productCategoryList);
    }

    @PostMapping()
    public ResponseResult<ProductCategory> insertProductCategory(@RequestBody ProductCategory productCategory){
        productCategoryService.insertProductCategory(productCategory);
        return new ResponseResult<>(CommonCode.SUCCESS,productCategory);
    }

    @PutMapping()
    public ResponseResult<ProductCategory> updateProductCategory(@RequestBody ProductCategory productCategory){
        productCategoryService.updateProductCategory(productCategory);
        return new ResponseResult<>(CommonCode.SUCCESS,productCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseResult<ProductCategory> deleteProductCategoryById(@PathVariable(value = "id")int id){
        productCategoryService.deleteProductCategoryById(id);
        return new ResponseResult<>(CommonCode.SUCCESS);
    }

}
