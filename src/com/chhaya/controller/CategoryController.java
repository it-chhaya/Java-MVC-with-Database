package com.chhaya.controller;

import com.chhaya.model.dao.impl.CategoryDaoImpl;
import com.chhaya.model.dto.Category;
import com.chhaya.view.CategoryView;

import java.util.List;

public class CategoryController {

    private CategoryDaoImpl categoryDao;
    private CategoryView categoryView;

    public CategoryController(CategoryDaoImpl categoryDao, CategoryView categoryView) {
        this.categoryDao = categoryDao;
        this.categoryView = categoryView;
    }

    public void saveCategory() {
        Category category = categoryView.saveCategoryView();
        if (category != null) {
            int result = categoryDao.save(category);
            if (result == 1)
                System.out.println("Category is saved.");
            else
                System.out.println("Category cannot saved.");
        }
    }

    public void findCategoryById() {
        int id = categoryView.findCategoryByIdView();
        if (id > 0) {
            Category category = categoryDao.find(id);
            if (category != null) {
                System.out.println("Category is found");
                System.out.println(category);
            }
            else {
                System.out.println("Category is not found");
            }
        }
    }

    public void findAllCategories(int page, int limit) {

        List<Category> categories = categoryDao.findAll(page, limit);

        categories.forEach(System.out::println);

    }

    public void deleteCategoryById() {
        int result = categoryDao.delete(categoryView.findCategoryByIdView());
        if (result == 1)
            System.out.println("Deleted successfully");
        else
            System.out.println("Delete failed");
    }


}
