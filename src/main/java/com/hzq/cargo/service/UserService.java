package com.hzq.cargo.service;

import com.hzq.cargo.mapper.UserMapper;
import com.hzq.cargo.entities.User;
import com.hzq.cargo.exception.ExceptionCast;
import com.hzq.cargo.util.SqlCode;
import com.hzq.cargo.util.UserCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-07-09 16:20
 */

@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    /**
     * 用户登录
     * @param user 用户对象
     */
    public User login(User user){
        int login = userMapper.login(user);
        if (login<1){
            ExceptionCast.cast(UserCode.USERNAME_OR_PASSWORD_ERROR);
        }
        return this.getUserByUserName(user.getUsername());
    }

    /**
     * 添加用户
     * @param user 用户对象
     * @return 添加结果和数据
     */
    public User saveUser(User user){
        int userByUserName = this.selectByUserName(user.getUsername());
        //判断用户是否存在
        if (userByUserName>0){
            ExceptionCast.cast(UserCode.USER_EXIST);
        }
        int i = userMapper.saveUser(user);
        if (i<1){
            ExceptionCast.cast(SqlCode.SAVE_FAIL);
        }
        return user;
    }


    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return >0表示用户存在
     */
    public User getUserByUserName(String username){
        User userByUserName = userMapper.getUserByUserName(username);
        if (userByUserName==null){
            ExceptionCast.cast(UserCode.USER_NOT_EXIST);
        }
        return userByUserName;
    }

    /**
     * 修改用户
     * @param user 用户名
     * @return  修改后的用户
     */
    public User updateUser(User user){
        int i = userMapper.updateUser(user);
        if (i<1){
            ExceptionCast.cast(SqlCode.SAVE_FAIL);
        }
        return user;
    }

    /**
     * 根据用户名删除用户
     * @param username 用户名
     */
    public void deleteUserByUserName(String username){
        int i = userMapper.deleteUserByUserName(username);
        if (i<1){
            ExceptionCast.cast(SqlCode.DELETE_FAIL);
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
