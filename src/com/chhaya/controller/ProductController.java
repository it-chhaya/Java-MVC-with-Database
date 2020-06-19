package com.chhaya.controller;

import com.chhaya.model.dao.impl.CategoryDaoImpl;
import com.chhaya.model.dao.impl.ProductDaoImpl;
import com.chhaya.model.dto.Category;
import com.chhaya.model.dto.Product;
import com.chhaya.utils.MsgUtils;
import com.chhaya.utils.Pagination;
import com.chhaya.view.ProductView;

public class ProductController {

    private ProductDaoImpl productDao;
    private ProductView productView;

    private CategoryDaoImpl categoryDao;

    public ProductController(ProductDaoImpl productDao, ProductView productView) {
        this.productDao = productDao;
        this.productView = productView;
    }

    public void setCategoryDao(CategoryDaoImpl categoryDao) {
        this.categoryDao = categoryDao;
    }

    public void insertProduct() {
        Product product = productView.insertProductView();
        int result = productDao.save(product);

        if (result != 0) {
            MsgUtils.showMsg("SUCCEED", "Product is saved!");
            productView.displayOneProductView(product);
        } else {
            MsgUtils.showMsg("FAILURE", "Product is not saved!");
        }
    }

    public Category getCategoryById(int id) {
        return categoryDao.find(id);
    }

    public void viewProductByID() {
        int id = productView.findProductByIdView();
        Product product = productDao.find(id);
        if (product != null){
            MsgUtils.showMsg("Success","Your product");
            productView.displayOneProductView(product);
        }else {
            MsgUtils.showMsg("fail","Your product doesn't exist");
        }
    }

    public void displayAllProduct(Pagination pages) {
        productView.displayProduct(productDao.findAll(pages), pages);
    }

    public int count(){
        return productDao.count();
    }

}
