package com.chhaya.controller;

import com.chhaya.utils.constants.MenuConstants;
import com.chhaya.utils.MsgUtils;
import com.chhaya.utils.Pagination;
import com.chhaya.view.MenuView;

import java.io.IOException;

public class MenuController {

    private final MenuView menuView;
    private final CategoryController categoryController;
    private final ProductController productController;
    private final Pagination paging;

    public MenuController(MenuView menuView,
                          CategoryController categoryController,
                          ProductController productController) {
        this.menuView = menuView;
        this.categoryController = categoryController;
        this.productController = productController;
        this.paging = new Pagination();
    }

    public void display() {

        int option = menuView.displayMainMenu();

        System.out.println("+--------------------+------------------------------------+");

        switch (option) {
            case 1: {
                processCategoryMenu();
                break;
            }
            case 2: {
                processProductMenu();
                break;
            }
            case 3: {
                System.out.println("Help");
                break;
            }
            case 4: {
                System.exit(0);
            }
            default: {
                System.out.println(MenuConstants.INVALID_OPTION_MENU);
            }

        }

        System.out.println("+--------------------+------------------------------------+");
        display();

    }

    public void processCategoryMenu() {

        System.out.println(MenuConstants.CATEGORY_MANAGEMENT);
        String option = menuView.displaySubMenu();
        System.out.println("+--------------------+------------------------------------+");

        switch (option.toLowerCase()) {
            case "a": {
                paging.setTotalRecords(categoryController.countCategory());
                categoryController.findAllCategories(paging);
                break;
            }
            case "w": {
                categoryController.saveCategory();
                break;
            }
            case "r": {
                categoryController.findCategoryById();
                break;
            }
            case "d": {
                categoryController.deleteCategoryById();
                break;
            }
            case "u": {
                categoryController.updateCategoryById();
                break;
            }
            case "s": {
                categoryController.findAllCategoriesByName(paging);
                break;
            }
            case "f": {
                paging.setTotalRecords(categoryController.countCategory());
                paging.setPage(1);
                categoryController.findAllCategories(paging);
                break;
            }
            case "p": {
                paging.setTotalRecords(categoryController.countCategory());
                if (paging.getPage() - 1 >= 1) {
                    paging.setPage(paging.getPage() - 1);
                    categoryController.findAllCategories(paging);
                } else {
                    MsgUtils.showMsg("FAILURE", "Invalid Page");
                }
                break;
            }
            case "n": {
                paging.setTotalRecords(categoryController.countCategory());
                if (paging.getPage() + 1 <= paging.getTotalPages()) {
                    paging.setPage(paging.getPage() + 1);
                    categoryController.findAllCategories(paging);
                } else {
                    MsgUtils.showMsg("FAILURE", "Invalid Page");
                }
                break;
            }
            case "l": {
                paging.setTotalRecords(categoryController.countCategory());
                paging.setPage(paging.getTotalPages());
                categoryController.findAllCategories(paging);
                break;
            }
            case "g": {
                paging.setPage(categoryController.gotoPage());
                if (paging.getPage() > 0 && paging.getPage() <= paging.getTotalPages()) {
                    categoryController.findAllCategories(paging);
                } else {
                    MsgUtils.showMsg("FAILURE", "Invalid Page");
                }

                break;
            }
            case "e": {
                display();
            }
            default: {
                System.out.println(MenuConstants.INVALID_OPTION_MENU);
            }
        }

        System.out.println("+--------------------+------------------------------------+");

        try {
            System.out.println("Press enter to continue...");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("+--------------------+------------------------------------+");
        for (int i = 0; i < 25; i++) {
            System.out.println("+--                                                     --+");
        }
        System.out.println("+--------------------+------------------------------------+");

        processCategoryMenu();

    }

    public void processProductMenu() {
        System.out.println(MenuConstants.PRODUCT_MANAGEMENT);
        String option = menuView.displaySubMenu();
        System.out.println("+--------------------+------------------------------------+");

        switch (option.toLowerCase()) {
            case "a": {
                paging.setTotalRecords(productController.count());
                productController.displayAllProduct(paging);
                break;
            }
            case "w": {
                productController.insertProduct();
                break;
            }
            case "r": {
                productController.viewProductByID();
                break;
            }
            case "d": {
                //categoryController.deleteCategoryById();
                break;
            }
            case "u": {
                //categoryController.updateCategoryById();
                break;
            }
            case "s": {
                //categoryController.findAllCategoriesByName(paging);
                break;
            }
            case "f": {
                paging.setTotalRecords(productController.count());
                paging.setPage(1);
                productController.displayAllProduct(paging);
                break;
            }
            case "p": {
                paging.setTotalRecords(productController.count());
                if (paging.getPage() - 1 >= 1) {
                    paging.setPage(paging.getPage() - 1);
                    productController.displayAllProduct(paging);
                } else {
                    MsgUtils.showMsg("FAILURE", "Invalid Page");
                }
                break;
            }
            case "n": {
                paging.setTotalRecords(productController.count());
                if (paging.getPage() + 1 <= paging.getTotalPages()) {
                    paging.setPage(paging.getPage() + 1);
                    productController.displayAllProduct(paging);
                } else {
                    MsgUtils.showMsg("FAILURE", "Invalid Page");
                }
                break;
            }
            case "l": {
                paging.setTotalRecords(productController.count());
                paging.setPage(paging.getTotalPages());
                categoryController.findAllCategories(paging);
                break;
            }
            case "g": {
                paging.setPage(categoryController.gotoPage());
                if (paging.getPage() > 0 && paging.getPage() <= paging.getTotalPages()) {
                    productController.displayAllProduct(paging);
                } else {
                    MsgUtils.showMsg("FAILURE", "Invalid Page");
                }
                break;
            }
            case "e": {
                display();
            }
            default: {
                System.out.println(MenuConstants.INVALID_OPTION_MENU);
            }
        }

        System.out.println("+--------------------+------------------------------------+");

        try {
            System.out.println("Press enter to continue...");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("+--------------------+------------------------------------+");
        for (int i = 0; i < 25; i++) {
            System.out.println("+--                                                     --+");
        }
        System.out.println("+--------------------+------------------------------------+");

        processProductMenu();
    }

}
