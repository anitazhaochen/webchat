package com.zc.service.impl;

import com.zc.mapper.MessageMapper;
import com.zc.model.Message;
import com.zc.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private MessageMapper messageMapper;


    @Override
    public int save(Message message) {
        messageMapper.save(message);
        return 0;
    }

    @Override
    public Message getMessageByUser() {
        Message message = messageMapper.findMessageByUser();
        return message;
    }
}
