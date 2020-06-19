package com.chhaya.utils.sql;

public class ProductSQL {

    public static String insert() {
        return "INSERT INTO products (id, name, qty, price, imported_date, category_id) " +
                "VALUES (?,?,?,?,?,?)";
    }

}
