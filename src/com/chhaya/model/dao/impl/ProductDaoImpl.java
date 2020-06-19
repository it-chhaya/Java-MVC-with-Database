package com.chhaya.model.dao.impl;

import com.chhaya.model.dao.ProductDao;
import com.chhaya.model.dto.Product;
import com.chhaya.utils.DbUtil;
import com.chhaya.utils.sql.ProductSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private final Connection con;

    public ProductDaoImpl() {
        con = DbUtil.getConnection();
    }

    @Override
    public int save(Product product) {

        int result = 0;

        try (PreparedStatement pstmt = con.prepareStatement(ProductSQL.insert())) {
            pstmt.setInt(1, product.getId());
            pstmt.setString(2, product.getName());
            pstmt.setInt(3, product.getQty());
            pstmt.setDouble(4, product.getPrice());
            pstmt.setDate(5, product.getImportedDate());
            pstmt.setInt(6, product.getCategory().getId());
            result = pstmt.executeUpdate();
            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;

    }

    @Override
    public Product find(int id) {
        return null;
    }

    @Override
    public List<Product> findAll(int page, int limit) {
        return null;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int update(Product newProduct) {
        return 0;
    }

}
