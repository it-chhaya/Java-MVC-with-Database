package com.chhaya.model.dao;

import com.chhaya.model.dto.Category;
import com.chhaya.utils.Pagination;

import java.util.List;

public interface CategoryDao {

    int save(Category category);
    Category find(int id);
    List<Category> findAll(Pagination paging);
    List<Category> findAllByName(Pagination paging, String name);
    int delete(int id);
    int update(Category newCategory);
    int count();
    int countByName(String name);

}
