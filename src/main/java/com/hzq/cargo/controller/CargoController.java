package com.hzq.cargo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzq.cargo.dto.CargoDTO;
import com.hzq.cargo.entities.Cargo;
import com.hzq.cargo.service.CargoService;
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
 * @date 2020-08-24 9:40
 */
@RestController
@RequestMapping("/api/cargo")
public class CargoController {
    @Autowired
    CargoService cargoService;

    @PostMapping("/save")
    public ResponseResult<Cargo> saveCargo(@RequestBody Cargo cargo){
        Cargo cargoSave = cargoService.saveCargo(cargo);
        return new ResponseResult<>(CommonCode.SUCCESS,cargoSave);
    }
    @DeleteMapping("/deleteCargoById/{id}")
    public ResponseResult<Cargo> deleteCargoById(@PathVariable Long id){
        cargoService.deleteCargoById(id);
        return new ResponseResult<>(CommonCode.SUCCESS);
    }
    @GetMapping("/selectPage")
    public ResponseResult<List<Cargo>> selectCargoPage(CargoDTO cargoDTO, Pageable pageable){
        Page<Cargo> page = PageUtil.getPage(pageable);
        List<Cargo> cargoList = cargoService.selectPage(cargoDTO,page);
        Long total = PageUtil.getTotal(page);
        return new ResponseResult<>(CommonCode.SUCCESS,cargoList,total);
    }


}
