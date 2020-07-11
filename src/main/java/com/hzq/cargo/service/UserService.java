package com.hzq.cargo.service;

import com.hzq.cargo.dao.UserMapper;
import com.hzq.cargo.entities.User;
import com.hzq.cargo.util.CommonCode;
import com.hzq.cargo.util.CommonResult;
import com.hzq.cargo.util.UserCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-07-09 16:20
 */

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 用户登录
     * @param user 用户对象
     * @return 登录结果和数据
     */
    public CommonResult<User> login(User user){
        int login = userMapper.login(user);
        if (login>0){
            return this.getUserByUserName(user.getUsername());
        }else {
            return new CommonResult<>(UserCode.USERNAME_OR_PASSWORD_ERROR,null);
        }

    }

    /**
     * 添加用户
     * @param user 用户对象
     * @return 添加结果和数据
     */
    public CommonResult<User> saveUser(User user){
        int userByUserName = this.selectByUserName(user.getUsername());
        //判断用户是否存在
        if (userByUserName>0){
            return new CommonResult<>(UserCode.USER_EXIST,user);
        }else {
            int i = userMapper.saveUser(user);
            System.out.println(" 保存结果"+i);
            return new CommonResult<>(CommonCode.SUCCESS,user);
        }
    }


    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return >0表示用户存在
     */
    public CommonResult<User> getUserByUserName(String username){
        User userByUserName = userMapper.getUserByUserName(username);
        if (userByUserName==null){
            return new CommonResult<>(UserCode.USER_NOT_EXIST,null);

        }else {
            return new CommonResult<>(CommonCode.SUCCESS,userByUserName);
        }
    }

    /**
     * 修改用户
     * @param user 用户名
     * @return  修改后的用户
     */
    public CommonResult<User> updateUser(User user){
        int i = userMapper.updateUser(user);
        if (i>0){
            return new CommonResult<>(CommonCode.SUCCESS,user);
        }else {
            return new CommonResult<>(UserCode.USER_NOT_EXIST,null);
        }
    }

    public CommonResult<User> deleteUserByUserName(String username){
        int i = userMapper.deleteUserByUserName(username);
        if (i>0){
            return new CommonResult<>(CommonCode.SUCCESS,null);
        }else {
            return new CommonResult<>(UserCode.USER_NOT_EXIST,null);
        }
    }

    /**
     * 判断用户是否存在
     * @param username 用户名
     * @return >0表示用户存在
     */
    private int selectByUserName(String username){
        return userMapper.selectByUserName(username);
    }
}
