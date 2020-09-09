package com.hzq.cargo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzq.cargo.dto.TransactionDTO;
import com.hzq.cargo.entities.Transaction;

import java.util.List;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-09-02 14:54
 */
public interface TransactionMapper extends BaseMapper<Transaction> {
    IPage<TransactionDTO> selectListTransactionDTO(TransactionDTO transactionDTO,Page<TransactionDTO> page);
}
