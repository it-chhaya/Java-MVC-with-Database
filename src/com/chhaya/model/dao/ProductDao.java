package com.chhaya.model.dao;

import com.chhaya.model.dto.Product;
import com.chhaya.utils.Pagination;

import java.util.List;

public interface ProductDao {

    int save(Product product);
    Product find(int id);
    List<Product> findAll(Pagination pagination);
    List<Product> findByName(Pagination pagination,String s);
    int delete(int id);
    int update(Product newProduct);
    int count();


}
