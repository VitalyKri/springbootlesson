package ru.gb.spring1.message.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring1.message.entity.Message;
import ru.gb.spring1.message.service.MessageService;


@Controller
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;


    //форма создания сообщений
    @GetMapping("/create")
    public String showSimpleForm(Model model){
        Message message = new Message();
        model.addAttribute("message",message);
        return "message/create-message";
    }



    // обработчик формы создания и редактирования, /message/edit/{id}
    @PostMapping("/create")
    public String processForm(Message message){
        if (message.getId() == null){
            messageService.save(message);
        } else {
            messageService.edit(message);
        }
        return "redirect:/message/all"; // ключевое слово перенаправления
    }


    // показать 1 элемент,
    @GetMapping("/{id}") // localhost:8080/spring/message/{id}?random=true
    public String getMessageById(Model model,
                                 @PathVariable Integer id,
                                 @RequestParam(name = "random", defaultValue = "false",
                                 required = false) Boolean isRandom){
        Message message;
        if (isRandom){
            message = messageService.getRandomMessage();
        } else {
            message = messageService.findById(id);
        }
        model.addAttribute("message",message);
        return "message/message";
    }
    // показать все элементов,
    @GetMapping("/all")
    public String getAllMessages(Model model){
        model.addAttribute("messages",messageService.findAll());
        return "message/message-list";
    }


    // удаление /message/delete/{id}
    @GetMapping("/delete")
    public String deleteByID(@RequestParam Integer id){
        messageService.deleteByID(id);
        return "redirect:/message/all";
    }

    @GetMapping("/edit")
    public String editById(Model model,@RequestParam Integer id){
        Message message = messageService.findById(id);
        model.addAttribute("message",message);
        return "message/create-message";
    }
//    @ModelAttribute("info")
//    public String addAttribute(){
//        return "тра-ла-ла";
//    }
}
