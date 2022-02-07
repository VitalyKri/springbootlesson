//package ru.gb.classwork5.config;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.jdbc.datasource.SimpleDriverDataSource;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.io.IOException;
//import java.sql.Driver;
//import java.util.Properties;
//
//
//@Configuration
//@ComponentScan("ru.gb.classwork5")
//@EnableTransactionManagement
//@PropertySource("classpath:dao/jdbc.properties")
//public class HibernateConfig {
//    @Value("${driverClassName}")
//    private String driverClassName;
//    @Value("${url}")
//    private String url;
//    @Value("${usernameBase}")
//    private String username;
//    @Value("${password}")
//    private String password;
//
//    @Bean
//    public DataSource dataSource() {
//        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
//
//        try {
//            Class<? extends Driver> driver = (Class<? extends Driver>) Class.forName(driverClassName);
//            dataSource.setDriverClass(driver);
//            dataSource.setUrl(url);
//            dataSource.setUsername(username);
//            dataSource.setPassword(password);
//            return dataSource;
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Bean
//    public SessionFactory sessionFactory() throws IOException {
//        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource());
//        sessionFactoryBean.setPackagesToScan("ru.gb.classwork5");
//        sessionFactoryBean.setHibernateProperties(hibernateProperties());
//        sessionFactoryBean.afterPropertiesSet();
//        return sessionFactoryBean.getObject();
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() throws IOException {
//        return new HibernateTransactionManager(sessionFactory());
//    }
//
//    private Properties hibernateProperties() {
//        Properties hibernateProperties = new Properties();
//        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.ProgressDialect");// он сам решает какой синтаксис SQL
//        hibernateProperties.put("hibernate.format_sql", true); // вывод красивых логов
//        hibernateProperties.put("hibernate.use_sql_comments", true); // вывод красивых логов
//        hibernateProperties.put("hibernate.show_sql", true); // вывод красивых логов
//        hibernateProperties.put("hibernate.max_fetch_depth", 3); // минимум знаний настройки hibernate. максимальная глубина ссылко внутри колбаса
//        hibernateProperties.put("hibernate.jdbc.batch_size", 10); // какими пачками загружаются апдайты в 1 тразнакции
//        hibernateProperties.put("hibernate.fetch_size", 50);
//        return hibernateProperties;
//    }
//}
