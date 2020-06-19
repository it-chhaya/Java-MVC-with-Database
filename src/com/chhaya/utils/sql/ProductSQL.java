package com.chhaya.utils.sql;

public class ProductSQL {

    public static String insert() {
        return "INSERT INTO products (id, name, qty, price, imported_date, category_id) " +
                "VALUES (?,?,?,?,?,?)";
    }

    public static String selectByID(){
        return "Select * from products where id = ? ";
    }

    public static String selectByName(String name){
        return "Select * from products where name ilike '%"+ name +"%'";
    }

    public final static String selectAllProduct = "Select * from products order by id limit ? offset ?";

    public final static String count="select count(*) from products";

}
