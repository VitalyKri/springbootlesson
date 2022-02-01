package ru.gb.spring1.message;


public class HelloSpring {
//    public static void main(String[] args) {
//
//        runWithConfigNotSingleton();
//    }
//
//
//    public static void runWithContext(String[] args) {
//
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//
//        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
//
//        MessageRender messageRender = context.getBean(MessageRender.class);
//        messageRender.render();
//
//        context.close();
//    }
//
//    public static void runWithConfig() {
//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloConfiguration.class);
//
//        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
//
//        MessageRender messageRender = context.getBean(MessageRender.class);
//        messageRender.render();
//
//        context.close();
//    }
//
//    public static void runWithConfigNotSingleton() {
//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloConfiguration.class);
//
//        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
//
//
//        for (int i = 0; i < 5; i++) {
//            MessageRender messageRender = context.getBean(MessageRender.class);
//            messageRender.render();
//        }
//
//        context.close();
//    }
}
