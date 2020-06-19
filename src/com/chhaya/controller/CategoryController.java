package com.chhaya.controller;

import com.chhaya.model.dao.impl.CategoryDaoImpl;
import com.chhaya.model.dto.Category;
import com.chhaya.utils.MsgUtils;
import com.chhaya.utils.Pagination;
import com.chhaya.view.CategoryView;

import java.util.List;

public class CategoryController {

    private final CategoryDaoImpl categoryDao;
    private final CategoryView categoryView;

    public CategoryController(CategoryDaoImpl categoryDao, CategoryView categoryView) {
        this.categoryDao = categoryDao;
        this.categoryView = categoryView;
    }

    public void saveCategory() {
        Category category = categoryView.saveCategoryView();
        if (category != null) {
            int result = categoryDao.save(category);
            if (result == 1)
                MsgUtils.showMsg("SUCCEED", "Category saved!");
            else
                MsgUtils.showMsg("FAILURE", "Category not saved!");
        }
    }

    public void findCategoryById() {
        int id = categoryView.findCategoryByIdView();
        if (id > 0) {
            Category category = categoryDao.find(id);
            if (category != null) {
                MsgUtils.showMsg("SUCCEED", "Category found!");
                categoryView.displayOneCategoryView(category);
            }
            else {
                MsgUtils.showMsg("FAILURE", "Category not found!");
            }
        }
    }

    public void findAllCategories(Pagination paging) {

        List<Category> categories = categoryDao.findAll(paging);

        categoryView.displayCategories(categories, paging);

    }

    public void deleteCategoryById() {
        int result = categoryDao.delete(categoryView.findCategoryByIdView());
        if (result == 1)
            MsgUtils.showMsg("SUCCEED","Deleted!");
        else
            MsgUtils.showMsg("FAILURE", "Cannot delete!");
    }

    public void updateCategoryById() {

        Category newCategory = categoryView.updateCategoryView();

        int result = categoryDao.update(newCategory);

        if (result == 1) {
            MsgUtils.showMsg("SUCCEED", "Updated!");
            categoryView.displayOneCategoryView(newCategory);
        } else {
            MsgUtils.showMsg("FAILURE", "Cannot update!");
        }

    }

    public int countCategory() {
        return categoryDao.count();
    }

    public void findAllCategoriesByName(Pagination paging) {

        String name = categoryView.findCategoriesByNameView();
        int count = categoryDao.countByName(name);

        List<Category> categories = categoryDao.findAllByName(paging, name);
        paging.setTotalRecords(count);

        categoryView.displayCategories(categories, paging);

    }

    public int gotoPage() {
        return categoryView.gotoPageView();
    }


}
