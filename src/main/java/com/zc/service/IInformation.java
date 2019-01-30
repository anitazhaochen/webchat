package com.zc.service;

import com.zc.model.User;

public interface IInformation {

    public User getMyInformation();

    public int addUser();

    public User findUserById(int id);

    public User getFriendInformation();
}
