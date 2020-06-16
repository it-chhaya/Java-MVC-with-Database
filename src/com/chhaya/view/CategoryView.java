package com.chhaya.view;

import com.chhaya.model.dto.Category;
import com.chhaya.utils.IOUtils;
import org.nocrala.tools.texttablefmt.Table;

import java.util.Scanner;

public class CategoryView {

    public Category saveCategoryView() {
        int id = IOUtils.inputInteger("Enter category ID > ");
        String name = IOUtils.inputString("Enter category name > ");
        return new Category(id, name);
    }

    public int findCategoryByIdView() {
       return IOUtils.inputInteger("Enter category ID > ");
    }


    /*public static void main(String[] args) {
        new CategoryView().saveArticleView();
    }*/


}
