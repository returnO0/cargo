package com.hzq.cargo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzq.cargo.dto.TransactionDTO;
import com.hzq.cargo.entities.Transaction;
import com.hzq.cargo.exception.ExceptionCast;
import com.hzq.cargo.mapper.TransactionMapper;
import com.hzq.cargo.util.SqlCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-09-02 14:55
 */
@Service
public class TransactionService {
    @Resource
    private TransactionMapper transactionMapper;


    /**
     * 新增或更新交易记录
     * @param transaction 交易记录类
     * @return 更新后的交易记录类
     */
    public Transaction saveTransaction(Transaction transaction) {
        int i=0;
        if (transaction.getId()!=null){
            i = transactionMapper.updateById(transaction);
        }else {
            i = transactionMapper.insert(transaction);
        }
        if (i<1){
            ExceptionCast.cast(SqlCode.SAVE_FAIL);
        }
        return transaction;
    }

    /**
     * 分页查询交易记录
     * @param page 分页参数
     * @return 交易记录列表
     */
    public List<TransactionDTO> selectPage(Page<TransactionDTO> page) {
        IPage<TransactionDTO> cargoPage = transactionMapper.selectListTransactionDTO(page);
        return cargoPage.getRecords();
    }

    /**
     * 根据id删除交易记录
     * @param id 主键
     */
    public void deleteTransactionById(Long id) {
        int i = transactionMapper.deleteById(id);
        if (i<1){
            ExceptionCast.cast(SqlCode.DELETE_FAIL);
        }
    }
}
