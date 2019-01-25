package com.zc.service;

import com.zc.model.Message;

public interface IMessageService {

    public int save(Message message);
    public Message getMessageByUser();

}
