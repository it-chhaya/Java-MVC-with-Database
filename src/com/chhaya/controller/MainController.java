package com.chhaya.controller;

import com.chhaya.model.dao.impl.CategoryDaoImpl;
import com.chhaya.view.CategoryView;
import com.chhaya.view.MenuView;

public class MainController {

    public static void main(String[] args) {

        CategoryDaoImpl categoryDao = new CategoryDaoImpl();
        CategoryView categoryView = new CategoryView();
        MenuView menuView = new MenuView();
        CategoryController categoryController = new CategoryController(
                categoryDao, categoryView
        );

        MenuController menuController = new MenuController(menuView, categoryController);

        menuController.display();

    }

}
