package com.hzq.cargo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzq.cargo.entities.Customer;
import com.hzq.cargo.exception.ExceptionCast;
import com.hzq.cargo.mapper.CustomerMapper;
import com.hzq.cargo.util.SqlCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-09-02 14:56
 */
@Service
public class CustomerService {
    @Resource
    private CustomerMapper customerMapper;

    /**
     * 新增或更新顾客信息
     * @param customer 顾客信息类
     * @return 更新后的顾客信息类
     */
    public Customer saveCustomer(Customer customer) {
        int i=0;
        if (customer.getId()!=null){
            i = customerMapper.updateById(customer);
        }else {
            i = customerMapper.insert(customer);
        }
        if (i<1){
            ExceptionCast.cast(SqlCode.SAVE_FAIL);
        }
        return customer;
    }

    /**
     * 分页查询顾客信息
     * @param page 分页参数
     * @return 顾客信息列表
     */
    public List<Customer> selectPage(Page<Customer> page) {
        Page<Customer> cargoPage = customerMapper.selectPage(page,new QueryWrapper<>());
        return cargoPage.getRecords();
    }

    /**
     * 根据id删除顾客信息
     * @param id 主键
     */
    public void deleteCustomerById(Long id) {
        int i = customerMapper.deleteById(id);
        if (i<1){
            ExceptionCast.cast(SqlCode.DELETE_FAIL);
        }
    }
}
