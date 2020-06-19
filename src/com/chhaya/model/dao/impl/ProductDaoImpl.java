package com.chhaya.model.dao.impl;

import com.chhaya.model.dao.ProductDao;
import com.chhaya.model.dto.Category;
import com.chhaya.model.dto.Product;
import com.chhaya.utils.DbUtil;
import com.chhaya.utils.Pagination;
import com.chhaya.utils.sql.ProductSQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private final Connection con;
    CategoryDaoImpl categoryDao=new CategoryDaoImpl();
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
        try(PreparedStatement pstmt=con.
                prepareStatement(ProductSQL.selectByID())){
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                int pid = rs.getInt(1);
                String name = rs.getString(2);
                int qty = rs.getInt(3);
                double price = rs.getDouble(4);
                Date date = rs.getDate(5);
                int catID= rs.getInt(6);
                Category category=categoryDao.find(catID);
                return new Product(pid,name,qty,price,date,category);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Product> findAll(Pagination pagination) {
        List<Product> products = new ArrayList<>();
        try(PreparedStatement pstmt=con.
                prepareStatement(ProductSQL.selectAllProduct)){
            pstmt.setInt(1,pagination.getLimit());
            pstmt.setInt(2,pagination.getOffset());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                int pid = rs.getInt(1);
                String name = rs.getString(2);
                int qty = rs.getInt(3);
                double price = rs.getDouble(4);
                Date date = rs.getDate(5);
                int catID= rs.getInt(6);
                Category category=categoryDao.find(catID);
                products.add(new Product(pid,name,qty,price,date,category));
            }
            return products;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Product> findByName(Pagination pagination, String s) {
        List<Product> products = new ArrayList<>();
        try(PreparedStatement pstmt=con.
                prepareStatement(ProductSQL.selectByName(s))){
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                int pid = rs.getInt(1);
                String name = rs.getString(2);
                int qty = rs.getInt(3);
                double price = rs.getDouble(4);
                Date date = rs.getDate(5);
                int catID= rs.getInt(6);
                Category category=categoryDao.find(catID);
                products.add(new Product(pid,name,qty,price,date,category));
            }
            return products;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
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

    @Override
    public int count(){
        try(PreparedStatement pstmt=con.
                prepareStatement(ProductSQL.count)){
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

}
