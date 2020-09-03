package com.hzq.cargo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzq.cargo.dto.TransactionDTO;
import com.hzq.cargo.entities.Transaction;
import com.hzq.cargo.service.TransactionService;
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
 * @date 2020-09-02 14:57
 */
@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/save")
    public ResponseResult<Transaction> saveTransaction(@RequestBody Transaction transaction){
        Transaction transactionSave = transactionService.saveTransaction(transaction);
        return new ResponseResult<>(CommonCode.SUCCESS,transactionSave);
    }
    @DeleteMapping("/deleteTransactionById/{id}")
    public ResponseResult<Transaction> deleteTransactionById(@PathVariable Long id){
        transactionService.deleteTransactionById(id);
        return new ResponseResult<>(CommonCode.SUCCESS);
    }
    @GetMapping("/selectPage")
    public ResponseResult<List<TransactionDTO>> selectTransactionPage(Pageable pageable){
        Page<TransactionDTO> page = PageUtil.getPage(pageable);
        List<TransactionDTO> transactionList = transactionService.selectPage(page);
        Long total = PageUtil.getTotal(page);
        return new ResponseResult<>(CommonCode.SUCCESS,transactionList,total);
    }
}
