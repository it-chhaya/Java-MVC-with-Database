package com.chhaya.model.dao.impl;

import com.chhaya.model.dao.CategoryDao;
import com.chhaya.model.dto.Category;
import com.chhaya.utils.DbUtil;
import com.chhaya.utils.Pagination;
import com.chhaya.utils.sql.CategorySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    private final Connection con;

    public CategoryDaoImpl() {
        con = DbUtil.getConnection();
    }

    @Override
    public int save(Category category) {

        int result = 0;

        try (PreparedStatement pstmt = con.prepareStatement(CategorySQL.insertCategory(category))) {
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;

    }

    @Override
    public Category find(int id) {

        Category category = null;

        try (PreparedStatement pstmt = con.prepareStatement(CategorySQL.findCategoryById(id))) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
                category = new Category(rs.getInt("id"), rs.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return category;

    }

    @Override
    public List<Category> findAll(Pagination paging) {

        List<Category> categories = new ArrayList<>();

        try (PreparedStatement pstmt = con.prepareStatement(CategorySQL.findAllCategories(paging.getLimit(), paging.getOffset()))) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                categories.add(new Category(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

    @Override
    public int delete(int id) {

        int result = 0;

        try (PreparedStatement pstmt = con.prepareStatement(CategorySQL.deleteCategoryById(id))) {
            result = pstmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int update(Category newCategory) {

        int result = 0;

        try (PreparedStatement pstmt =
                     con.prepareStatement(CategorySQL.updateCategoryById())) {

            pstmt.setString(1, newCategory.getName());
            pstmt.setInt(2, newCategory.getId());

            result = pstmt.executeUpdate();

            if (result == 1) {
                return result;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int count() {

        int result = 0;

        try (PreparedStatement pstmt =
                     con.prepareStatement(CategorySQL.countCategories())) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.next())
                result = rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Category> findAllByName(Pagination paging, String name) {
        List<Category> categories = new ArrayList<>();

        try (PreparedStatement pstmt = con.prepareStatement(CategorySQL.findCategoryByName(paging, name))) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                categories.add(new Category(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

    @Override
    public int countByName(String name) {
        int result = 0;

        try (PreparedStatement pstmt =
                     con.prepareStatement(CategorySQL.countCategoriesByName(name))) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.next())
                result = rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
