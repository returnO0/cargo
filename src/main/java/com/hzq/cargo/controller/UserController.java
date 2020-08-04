package com.hzq.cargo.controller;

import com.hzq.cargo.entities.User;
import com.hzq.cargo.service.UserService;
import com.hzq.cargo.util.CommonCode;
import com.hzq.cargo.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-07-10 09:45
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseResult<User> login(@RequestBody User user){
        user = userService.login(user);
        return new ResponseResult<>(CommonCode.SUCCESS,user);
    }

    @PostMapping()
    public ResponseResult<User> saveUser(User user){
        return new ResponseResult<>(CommonCode.SUCCESS,userService.saveUser(user));
    }

    @GetMapping("/{username}")
    public ResponseResult<User> getUserByUserName(@PathVariable String username){
        return new ResponseResult<>(CommonCode.SUCCESS,userService.getUserByUserName(username));
    }
    @PutMapping
    public ResponseResult<User> updateUser(User user){
        return new ResponseResult<>(CommonCode.SUCCESS,userService.updateUser(user));
    }
    @DeleteMapping("/{username}")
    public ResponseResult<User> deleteUserByUserName(@PathVariable String username){
        userService.deleteUserByUserName(username);
        return new ResponseResult<>(CommonCode.SUCCESS);
    }
}
