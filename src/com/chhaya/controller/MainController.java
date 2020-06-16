package com.chhaya.controller;

import com.chhaya.model.dao.impl.CategoryDaoImpl;
import com.chhaya.view.CategoryView;

public class MainController {

    public static void main(String[] args) {

        CategoryDaoImpl categoryDao = new CategoryDaoImpl();
        CategoryView categoryView = new CategoryView();

        CategoryController categoryController = new CategoryController(
                categoryDao, categoryView
        );

        //categoryController.saveCategory();
        //categoryController.findCategoryById();
        //categoryController.findAllCategories(3,1);
        categoryController.deleteCategoryById();

    }

}
