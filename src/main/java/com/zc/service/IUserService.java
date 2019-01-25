package com.zc.service;

import com.zc.model.User;

public interface IUserService {

    public void register(String username, String password);
    public User findByUsername(String username);
}

