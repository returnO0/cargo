package com.hzq.cargo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzq.cargo.dto.CargoDTO;
import com.hzq.cargo.entities.Cargo;
import com.hzq.cargo.exception.ExceptionCast;
import com.hzq.cargo.mapper.CargoMapper;
import com.hzq.cargo.util.SqlCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-08-24 9:40
 */
@Slf4j
@Service
public class CargoService {
    @Resource
    private CargoMapper cargoMapper;

    /**
     * 新增或更新货物信息
     * @param cargo 货物信息类
     * @return 更新后的货物信息类
     */
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

    /**
     * 分页查询货物信息
     * @param page 分页参数
     * @return 货物信息列表
     */
    public List<Cargo> selectPage(CargoDTO cargoDTO, Page<Cargo> page) {
        //货物名称
        String name = cargoDTO.getName();
        //货物库存区间
        Long inventoryFrom = cargoDTO.getInventoryFrom();
        Long inventoryTo = cargoDTO.getInventoryTo();
        //价格区间
        BigDecimal priceFrom = cargoDTO.getPriceFrom();
        BigDecimal priceTo = cargoDTO.getPriceTo();
        //备注
        String note = cargoDTO.getNote();
        //查询条件对象
        Wrapper<Cargo> queryWrapper = new QueryWrapper<Cargo>()
                .like(name !=null,"name",name)
                .ge(inventoryFrom!=null,"inventory",inventoryFrom)
                .le(inventoryTo!=null,"inventory",inventoryTo)
                .ge(priceFrom!=null,"price",priceFrom)
                .le(priceTo!=null,"price",priceTo)
                .like(note!=null,"note",note);
        Page<Cargo> cargoPage = cargoMapper.selectPage(page,queryWrapper);
        return cargoPage.getRecords();
    }

    /**
     * 根据id删除货物信息
     * @param id 主键
     */
    public void deleteCargoById(Long id) {
        int i = cargoMapper.deleteById(id);
        if (i<1){
            ExceptionCast.cast(SqlCode.DELETE_FAIL);
        }
    }
}
