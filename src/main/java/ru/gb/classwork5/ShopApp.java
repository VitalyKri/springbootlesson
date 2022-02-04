package ru.gb.classwork5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import ru.gb.classwork5.config.HibernateConfig;
import ru.gb.classwork5.dao.product.ProductDao;
import ru.gb.classwork5.entity.Product;


public class ShopApp {

    public static void main(String[] args) {
//        OldJdbcManufacturerDao oldJdbcManufacturerDao = new OldJdbcManufacturerDao();
//
//
//        for (Manufacturer manufacturer : oldJdbcManufacturerDao.findAll()) {
//            System.out.println(manufacturer);
//        }

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        ProductDao manufacturerDao = context.getBean(ProductDao.class);
        System.out.println(manufacturerDao.findById(9L));

        for (Product manufacturer : manufacturerDao.findAll()) {
            System.out.println(manufacturer);
        }
    }
}
