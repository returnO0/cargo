package com.hzq.cargo.dao;

import com.hzq.cargo.entities.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhiqiang.hu01@hand-china.com
 * @description
 * @date 2020-07-09 16:16
 */
@Mapper
public interface UserMapper {
    int login(User user);
    int saveUser(User user);
    int selectByUserName(String username);
    User getUserByUserName(String username);
    int updateUser(User user);
    int deleteUserByUserName(String username);
}
