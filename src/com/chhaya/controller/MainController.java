package com.chhaya.controller;

import com.chhaya.model.dao.impl.CategoryDaoImpl;
import com.chhaya.model.dao.impl.ProductDaoImpl;
import com.chhaya.view.CategoryView;
import com.chhaya.view.MenuView;
import com.chhaya.view.ProductView;

public class MainController {

    public static void main(String[] args) {

        CategoryDaoImpl categoryDao = new CategoryDaoImpl();
        CategoryView categoryView = new CategoryView();
        MenuView menuView = new MenuView();
        CategoryController categoryController = new CategoryController(
                categoryDao, categoryView
        );

        ProductDaoImpl productDao = new ProductDaoImpl();
        ProductView productView = new ProductView();
        ProductController productController = new ProductController(
                productDao, productView
        );
        productController.setCategoryDao(categoryDao);
        productView.setProductController(productController);

        MenuController menuController = new MenuController(menuView,
                categoryController, productController);

        menuController.display();

    }

}
