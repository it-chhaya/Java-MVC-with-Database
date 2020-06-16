package com.chhaya.utils;

import com.chhaya.model.dto.Category;

public class SQLConstants {

    public static String insertCategory(Category category) {
        return "INSERT INTO categories (id, name) " +
                "VALUES (" + category.getId() + ",'" + category.getName() + "')";
    }

    public static String findCategoryById(int id) {
        return "SELECT * FROM categories WHERE id = " + id;
    }

    public static String findAllCategories(int limit, int offset) {
        return "SELECT * FROM categories ORDER BY id LIMIT " + limit + " OFFSET " + offset;
    }

    public static String deleteCategoryById(int id) {
        return "DELETE FROM categories WHERE id = " + id;
    }

}
