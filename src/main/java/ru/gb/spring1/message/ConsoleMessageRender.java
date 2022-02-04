package ru.gb.spring1.message;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component

public class ConsoleMessageRender implements MessageRender {


    // он зависит messageProvider, т.е. messageProvider является зависимостью для ConsoleMessageRender;

    @Override
    public void render() {
        System.out.println(getMessageProvider().getMessage());
    }

//    @Override
//    public void setMessageProvider(MessageProvider messageProvider) {
//        this.messageProvider = messageProvider;
//    }

//    @Autowired
//    //@Qualifier("like")
//            MessageProvider messageProvider;

    @Lookup
    @Override
    public MessageProvider getMessageProvider() {
        return null;
    }
}
