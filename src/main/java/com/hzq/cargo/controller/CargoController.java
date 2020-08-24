package com.hzq.cargo.controller;

import com.hzq.cargo.entities.Cargo;
import com.hzq.cargo.service.CargoService;
import com.hzq.cargo.util.CommonCode;
import com.hzq.cargo.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-08-24 9:40
 */
@RestController
@RequestMapping("/cargo")
public class CargoController {
    @Autowired
    CargoService cargoService;

    @PostMapping("/save")
    public ResponseResult<Cargo> saveCargo(@RequestBody Cargo cargo){
        Cargo cargoSave = cargoService.saveCargo(cargo);
        return new ResponseResult<>(CommonCode.SUCCESS,cargoSave);
    }

}
