package ru.gb.spring1.message;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component("like")
@Profile("like")
@Scope("prototype")
public class LikeMessageProvider implements MessageProvider {

    @InjectFoodStuff
    private String stuff;

    @Value("${listOfFoodStuff}")
    String[] like;

    @PostConstruct
    public void init(){
        System.out.println(Arrays.asList(like));
    }
    @Override
    public String getMessage() {
        return "I like "+ stuff;
    }
}
