package com.chhaya.model.dao.impl;

import com.chhaya.model.dao.CategoryDao;
import com.chhaya.model.dto.Category;
import com.chhaya.utils.DbUtil;
import com.chhaya.utils.Pagination;
import com.chhaya.utils.SQLConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    private Connection con;

    public CategoryDaoImpl() {
        con = DbUtil.getConnection();
    }

    @Override
    public int save(Category category) {

        int result = 0;

        try (PreparedStatement pstmt = con.prepareStatement(SQLConstants.insertCategory(category))) {
            System.out.println(SQLConstants.insertCategory(category));
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;

    }

    @Override
    public Category find(int id) {

        Category category = null;

        try (PreparedStatement pstmt = con.prepareStatement(SQLConstants.findCategoryById(id))) {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
                category = new Category(rs.getInt("id"), rs.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return category;

    }

    @Override
    public List<Category> findAll(int page, int limit) {

        List<Category> categories = new ArrayList<>();

        Pagination paging = new Pagination();
        paging.setPage(page);
        paging.setLimit(limit);

        try (PreparedStatement pstmt = con.prepareStatement(SQLConstants.findAllCategories(paging.getLimit(), paging.getOffset()))) {
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

        try (PreparedStatement pstmt = con.prepareStatement(SQLConstants.deleteCategoryById(id))) {
            result = pstmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int update(Category newCategory) {
        return 0;
    }

}
