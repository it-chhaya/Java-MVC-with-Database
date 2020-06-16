package com.chhaya.model.dao;

import com.chhaya.model.dto.Product;

import java.util.List;

public interface ProductDao {

    int save(Product product);
    Product find(int id);
    List<Product> findAll(int page, int limit);
    int delete(int id);
    int update(Product newProduct);

}
