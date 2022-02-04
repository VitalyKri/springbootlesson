package ru.gb.classwork5.dao.product;


import ru.gb.classwork5.entity.Product;

public interface ProductDao {

    Iterable<Product> findAll();
    Product findById(Long id);

}
