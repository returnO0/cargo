package com.hzq.cargo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hzq.cargo.mapper")
public class CargoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CargoApplication.class, args);
    }

}
