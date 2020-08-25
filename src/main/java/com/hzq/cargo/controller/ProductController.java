package com.hzq.cargo.controller;

import com.hzq.cargo.dto.ProductDTO;
import com.hzq.cargo.entities.Product;
import com.hzq.cargo.service.ProductService;
import com.hzq.cargo.util.CommonCode;
import com.hzq.cargo.util.PageUtil;
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
    public ResponseResult<List<ProductDTO>> selectList(
            @RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "10") int size){
        PageUtil<ProductDTO> productPageUtil = productService.selectList(page, size);
        List<ProductDTO> products = productPageUtil.getRecords();
        Long total = productPageUtil.getTotal();
        return new ResponseResult<>(CommonCode.SUCCESS,products,total);
    }
    @GetMapping("/selectListByName")
    public ResponseResult<List<ProductDTO>> selectListByName(
            @RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "10") int size,
            @RequestParam(value = "name") String name){
        PageUtil<ProductDTO> productPageUtil = productService.selectListByName(page, size,name);
        List<ProductDTO> products = productPageUtil.getRecords();
        Long total = productPageUtil.getTotal();
        return new ResponseResult<>(CommonCode.SUCCESS,products,total);
    }

    @GetMapping("/selectListByDescription")
    public ResponseResult<List<ProductDTO>> selectListByDescription(
            @RequestParam(value = "page",defaultValue = "0") int page,
            @RequestParam(value = "size",defaultValue = "10") int size,
            @RequestParam(value = "description") String description){
        PageUtil<ProductDTO> productPageUtil = productService.selectListByDescription(page, size,description);
        List<ProductDTO> products = productPageUtil.getRecords();
        Long total = productPageUtil.getTotal();
        return new ResponseResult<>(CommonCode.SUCCESS,products,total);
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

    @GetMapping("/updateStatus/{id}")
    public ResponseResult<Product> updateStatus(@PathVariable Long id){
        productService.updateStatus(id);
        return new ResponseResult<>(CommonCode.SUCCESS);
    }

}
