package ru.gb.spring1.message.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;
import ru.gb.spring1.message.MessageProvider;
import ru.gb.spring1.message.entity.Message;
import ru.gb.spring1.message.repository.MessageRepository;


import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    public Message save(Message message){
        return messageRepository.save(message);
    }

    public Message edit(Message message){
        return messageRepository.edit(message);
    }

    public Message findById(Integer id){
        return messageRepository.findById(id).orElseThrow(()-> new NoSuchElementException());
    }

    public List<Message> findAll(){
        return messageRepository.findAll();
    }

    public void deleteByID(Integer id){
       messageRepository.deleteByID(id);
    }

    public Message getRandomMessage(){
        return Message.builder()
                .body(getMessageProvider().getMessage())
                .from("Randomizer")
                .to("Browser")
                .build();
    }

    @Lookup
    public MessageProvider getMessageProvider(){
        return null;
    }

}
