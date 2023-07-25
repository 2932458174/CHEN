package com.demo.service;

import com.demo.dao.UserMapper;
import com.demo.utils.MybatisUtils;
import com.demo.dao.entity.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserService extends BaseService {
    public List<User> queryUserPageList(User user) {
        SqlSession session =MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        List<User> userList = mapper.selectPage(user);
        return userList;
    }


    public User queryUser(int id) {
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        return  mapper.selectUser(id);
    }

    public int updateStatus(User user) {
        SqlSession session =MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        return mapper.updateStatus(user);
    }

    public int deleteById(User user) {
        SqlSession session =MybatisUtils.getSqlSession();//实例化session
        UserMapper mapper = session.getMapper(UserMapper.class);
        return mapper.deleteById(user);//接口
    }

    public int updateById(User user) {
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        return mapper.updateById(user);
    }

    public int insertUser(User user){
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        return mapper.insertUser(user);
    }

    public User selectByUsername(User user) {
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        return mapper.selectByUsername(user);
    }

}
