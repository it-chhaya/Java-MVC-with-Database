package com.chhaya.controller;

import com.chhaya.model.dao.impl.CategoryDaoImpl;
import com.chhaya.utils.MenuConstants;
import com.chhaya.utils.Pagination;
import com.chhaya.view.CategoryView;
import com.chhaya.view.MenuView;

public class MenuController {

    private final MenuView menuView;
    private final CategoryController categoryController;

    public MenuController(MenuView menuView, CategoryController categoryController) {
        this.menuView = menuView;
        this.categoryController = categoryController;
    }

    public void display() {

        int option = menuView.displayMainMenu();

        System.out.println("------------------------");

        switch (option) {
            case 1: {
                processCategoryMenu();
                break;
            }
            case 2: {

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

        System.out.println("------------------------");
        display();

    }

    public void processCategoryMenu() {

        System.out.println(MenuConstants.CATEGORY_MANAGEMENT);
        String option = menuView.displaySubMenu();
        System.out.println("------------------------");

        switch (option.toLowerCase()) {
            case "a": {
                Pagination paging = new Pagination();
                paging.setTotalRecords(categoryController.countCategory());
                categoryController.findAllCategories(paging);
                break;
            }
            case "w": {
                System.out.println("Write");
                break;
            }
            case "r": {
                System.out.println("Read");
                break;
            }
            case "d": {
                System.out.println("Delete");
                break;
            }
            case "u": {
                System.out.println("Update");
                break;
            }
            case "s": {
                System.out.println("Search");
                break;
            }
            case "f": {
                System.out.println("Frist");
                break;
            }
            case "p": {
                System.out.println("Previous");
                break;
            }
            case "n": {
                System.out.println("Next");
                break;
            }
            case "l": {
                System.out.println("Last");
                break;
            }
            case "g": {
                System.out.println("Goto");
                break;
            }
            case "e": {
                System.out.println("Exit Sub Menu");
                break;
            }
            default: {
                System.out.println(MenuConstants.INVALID_OPTION_MENU);
            }
        }

        System.out.println("------------------------");
        processCategoryMenu();
    }

}
