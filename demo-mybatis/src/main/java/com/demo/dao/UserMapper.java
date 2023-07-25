package com.demo.dao;

import com.demo.dao.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> selectPage(User user);

    User selectUser(int id);

    int updateStatus(User user);

    int deleteById(User user);

    int updateById(User user);

    int insertUser(User user);

    User selectByUsername(User user);

}
