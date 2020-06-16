package com.chhaya.model.dao.impl;

import com.chhaya.model.dao.ProductDao;
import com.chhaya.model.dto.Product;

import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Override
    public int save(Product product) {
        return 0;
    }

    @Override
    public Product find(int id) {
        return null;
    }

    @Override
    public List<Product> findAll(int page, int limit) {
        return null;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int update(Product newProduct) {
        return 0;
    }

}
