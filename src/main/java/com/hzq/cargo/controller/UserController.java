package com.hzq.cargo.controller;

import com.hzq.cargo.entities.User;
import com.hzq.cargo.service.UserService;
import com.hzq.cargo.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-07-10 09:45
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user/login")
    public CommonResult<User> login(@RequestBody User user){
        return userService.login(user);
    }

    @PostMapping("/user")
    public CommonResult<User> saveUser(User user){
        return userService.saveUser(user);
    }
    @GetMapping("/user/{username}")
    public CommonResult<User> getUserByUserName(@PathVariable String username){
        return userService.getUserByUserName(username);
    }
    @PutMapping("/user")
    public CommonResult<User> updateUser(User user){
        return userService.updateUser(user);
    }
    @DeleteMapping("/user/{username}")
    public CommonResult<User> deleteUserByUserName(@PathVariable String username){
        return userService.deleteUserByUserName(username);
    }
}
