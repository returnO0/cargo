package com.hzq.cargo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzq.cargo.entities.Customer;
import com.hzq.cargo.service.CustomerService;
import com.hzq.cargo.util.CommonCode;
import com.hzq.cargo.util.PageUtil;
import com.hzq.cargo.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-09-02 14:56
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public ResponseResult<Customer> saveCustomer(@RequestBody Customer cargo){
        Customer cargoSave = customerService.saveCustomer(cargo);
        return new ResponseResult<>(CommonCode.SUCCESS,cargoSave);
    }
    @DeleteMapping("/deleteCustomerById/{id}")
    public ResponseResult<Customer> deleteCustomerById(@PathVariable Long id){
        customerService.deleteCustomerById(id);
        return new ResponseResult<>(CommonCode.SUCCESS);
    }
    @GetMapping("/selectPage")
    public ResponseResult<List<Customer>> selectCustomerPage(Customer customer,Pageable pageable){
        Page<Customer> page = PageUtil.getPage(pageable);
        List<Customer> cargoList = customerService.selectPage(customer,page);
        Long total = PageUtil.getTotal(page);
        return new ResponseResult<>(CommonCode.SUCCESS,cargoList,total);
    }
}
