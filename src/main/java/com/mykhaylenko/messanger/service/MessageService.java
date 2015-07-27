package com.mykhaylenko.messanger.service;

import com.mykhaylenko.messanger.database.DatabaseClass;
import com.mykhaylenko.messanger.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by pavlo.mykhaylenko on 7/27/2015.
 */
public class MessageService {

    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService() {
        messages.put(1L, new Message(1L, "first", "first"));
        messages.put(2L, new Message(2L, "second", "second"));
    }

    public List getAllMessages() {
        return new ArrayList(messages.values());
    }

    public Message getMessage(long id) {
        return messages.get(id);
    }

    public Message addMessage(Message message) {
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message) {
        if (messages.size() <= 0) {
            return null;
        }
        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long id) {
        return messages.remove(id);
    }
}
