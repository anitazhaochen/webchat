package com.zc.service.impl;


import com.zc.mapper.UserMapper;
import com.zc.model.User;
import com.zc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional // 使用事务
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(String username, String password) {
        userMapper.save(username, password);

    }

    @Override
    public User findByUsername(String username) {
        System.out.println(username);
        return userMapper.findByUsername(username);
    }
}
