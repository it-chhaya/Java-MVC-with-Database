package com.chhaya.utils.sql;

import com.chhaya.model.dto.Category;
import com.chhaya.utils.Pagination;

public class CategorySQL {

    public static String insertCategory(Category category) {
        return "INSERT INTO categories (id, name) " +
                "VALUES (" + category.getId() + ",'" + category.getName() + "')";
    }

    public static String findCategoryById(int id) {
        return "SELECT * FROM categories WHERE id = " + id;
    }

    public static String findCategoryByName(Pagination paging, String name) {
        return "SELECT * FROM categories " +
                "WHERE name ilike '" + name + "%' " +
                "ORDER BY id " +
                "LIMIT " + paging.getLimit() +
                " OFFSET " + paging.getOffset();
    }

    public static String findAllCategories(int limit, int offset) {
        return "SELECT * FROM categories ORDER BY id LIMIT " + limit + " OFFSET " + offset;
    }

    public static String deleteCategoryById(int id) {
        return "DELETE FROM categories WHERE id = " + id;
    }

    public static String updateCategoryById() {
        return "UPDATE categories" +
                " SET name = ?" +
                " WHERE id = ?";
    }

    public static String countCategories() {
        return "SELECT COUNT(*) FROM categories";
    }

    public static String countCategoriesByName(String name) {
        return "SELECT COUNT(*) FROM categories" +
                " WHERE name ilike '" + name + "%'";
    }

}
