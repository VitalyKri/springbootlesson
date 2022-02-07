package ru.gb.spring1.classwork.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring1.classwork.config.ProductProps;

@Controller
@RequestMapping("/hello")
@RequiredArgsConstructor
public class HelloController {

    private final ProductProps productProps;

    @ResponseBody
    @GetMapping
    public String helloMessage(){
        return "Hello my application";
    }

    @GetMapping("/message")
    public String helloMessageJsp(Model model){
        String message;
        if (productProps != null && !CollectionUtils.isEmpty(productProps.getProducts())){
            message = "Count of products:"+productProps.getProducts().size();
        } else {
            message = "Empty list of product";
        }
        model.addAttribute("msg",message);
        return "hello/message";
    }


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleRuntimeException(RuntimeException e){
        return "So sad, but error"+ e.getMessage();
    }

}
