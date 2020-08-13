package com.hzq.cargo.controller;

import com.hzq.cargo.entities.Product;
import com.hzq.cargo.service.ProductService;
import com.hzq.cargo.util.CommonCode;
import com.hzq.cargo.util.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-08-12 10:04
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;

    @GetMapping("/selectList")
    public ResponseResult<List<Product>> selectList(){
        List<Product> products = productService.selectList();
        return new ResponseResult<>(CommonCode.SUCCESS,products);
    }
    @GetMapping("/selectListByName")
    public ResponseResult<List<Product>> selectListByName(@RequestParam(value = "name") String name){
        List<Product> products = productService.selectListByName(name);
        return new ResponseResult<>(CommonCode.SUCCESS,products);
    }

    @GetMapping("/selectListByDescription")
    public ResponseResult<List<Product>> selectListByDescription(@RequestParam(value = "description") String description){
        List<Product> products = productService.selectListByDescription(description);
        return new ResponseResult<>(CommonCode.SUCCESS,products);
    }

    @GetMapping("/{id}")
    public ResponseResult<Product> selectById(@PathVariable Long id){
        Product product = productService.selectById(id);
        return new ResponseResult<>(CommonCode.SUCCESS,product);
    }

    @PostMapping()
    public ResponseResult<Product> insertProduct(@RequestBody Product product){
        Product newProduct = productService.insertProduct(product);
        return new ResponseResult<>(CommonCode.SUCCESS,newProduct);
    }

    @PutMapping
    public ResponseResult<Product> updateProduct(@RequestBody Product product){
        Product newProduct = productService.updateProduct(product);
        return new ResponseResult<>(CommonCode.SUCCESS,newProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseResult<Product> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return new ResponseResult<>(CommonCode.SUCCESS);
    }

}
