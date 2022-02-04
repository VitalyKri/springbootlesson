package ru.gb.spring1.message.repository;

import org.springframework.stereotype.Component;
import ru.gb.spring1.message.entity.Message;


import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

@Component
public class MessageRepository {

    ArrayList<Message> messages = new ArrayList<>();
    private int count = 0;
    public Message save(Message message){
        message.setId(count++);
        messages.add(message);
        // возвращаем копию, что бы не изменили нашу ссылку
        return Message.builder()
                .id(message.getId())
                .from(message.getFrom())
                .to(message.getTo())
                .body(message.getBody())
                .build();
    }

    public Message edit(Message message){
        Message set = messages.set(message.getId(), message);
        return Message.builder()
                .id(set.getId())
                .from(set.getFrom())
                .to(set.getTo())
                .body(set.getBody())
                .build();
    }

    public Optional<Message> findById(Integer id){
        if (id < messages.size()){
            return Optional.of(messages.get(id));
        } else {
            return Optional.empty();
        }
    }

    public List<Message> findAll(){
        return new ArrayList<>(messages);
    }

    public void deleteByID(Integer id){
        if (id < messages.size()){
            messages.remove(id);
        }
    }
}
