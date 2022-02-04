package ru.gb.spring1.message;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("hello")
@Profile("hello")
public class HelloSpringMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello Spring";
    }
}
