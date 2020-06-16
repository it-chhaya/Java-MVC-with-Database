package com.chhaya.model.dao;

import com.chhaya.model.dto.Category;

import java.util.List;

public interface CategoryDao {

    int save(Category category);
    Category find(int id);
    List<Category> findAll(int page, int limit);
    int delete(int id);
    int update(Category newCategory);

}
