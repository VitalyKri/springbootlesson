package ru.gb.spring1.message;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.Random;

@Component
public class InjectFoodStuffAnnotationBeanPostProcessor implements BeanPostProcessor {


    // пробегают раньше
    @Autowired
    Environment environment;

    @PostConstruct
    public void init(){
       food = environment.getProperty("listOfFoodStuff").split(",");
    }
    String[] food;

    // используется для полей
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Random random = new Random();
        for (Field field :
                bean.getClass().getDeclaredFields()) {
            if (field.getAnnotation(InjectFoodStuff.class) ==null){
                continue;
            }

            String foodStuff = food[random.nextInt(food.length-1)];
            field.setAccessible(true);
            try {
                field.set(bean,foodStuff);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            ReflectionUtils.setField(field,bean,foodStuff);

        }

        return bean;
    }


    // используется для доработки методов postProcessAfterInitialization


}
