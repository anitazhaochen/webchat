package com.zc.mapper;

import com.zc.model.Message;

public interface MessageMapper {

    public int save(Message message);

    public Message findMessageByUser();

}
