package com.hzq.cargo.service;

import com.hzq.cargo.entities.Cargo;
import com.hzq.cargo.exception.ExceptionCast;
import com.hzq.cargo.mapper.CargoMapper;
import com.hzq.cargo.util.CommonCode;
import com.hzq.cargo.util.SqlCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-08-24 9:40
 */
@Slf4j
@Service
public class CargoService {
    @Resource
    CargoMapper cargoMapper;

    public Cargo saveCargo(Cargo cargo) {
        int i=0;
        if (cargo.getId()!=null){
            i = cargoMapper.updateById(cargo);
        }else {
            i = cargoMapper.insert(cargo);
        }
        if (i<1){
            ExceptionCast.cast(SqlCode.SAVE_FAIL);
        }
        return cargo;
    }
}
