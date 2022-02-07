package ru.gb.spring1.classwork.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.gb.spring1.classwork.model.Product;

import java.util.List;


@ConfigurationProperties("shop.properties")
@Component
@Getter
@Setter
public class ProductProps {

    private List<Product> products;

    //@ConditionalOnProperty("spring.mvc.view.prefix")
    @Bean
    public String myBean(){
        System.out.println("my bean");
        return "bean";
    }
}
