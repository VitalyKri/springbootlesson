package ru.gb.classwork5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



import ru.gb.classwork5.config.JPAConfig;
import ru.gb.classwork5.dao.ManufacturerDao;
import ru.gb.classwork5.dao.cart.CartDao;

import ru.gb.classwork5.entity.Manufacturer;


public class ShopApp {

    public static void main(String[] args) {


//        OldJdbcManufacturerDao oldJdbcManufacturerDao = new OldJdbcManufacturerDao();
//
//
//        for (Manufacturer manufacturer : oldJdbcManufacturerDao.findAll()) {
//            System.out.println(manufacturer);
//        }

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
        ManufacturerDao manufacturerDao = context.getBean(ManufacturerDao.class);
        //CartDao cartDao = context.getBean(CartDao.class);
//        System.out.println(manufacturerDao.findById(9L));
//
        for (Manufacturer manufacturer : manufacturerDao.findAll()) {
            System.out.println(manufacturer);
        }

//        Product product = productDao.findAll().get(5);
//
//        HashSet<Product> products = new HashSet<>();
//        products.add(product);
//        Cart cart = Cart.builder()
//                .products(products).build();
//
//        cartDao.save(cart);


    }
}
