package com.chhaya.view;

import com.chhaya.controller.ProductController;
import com.chhaya.model.dto.Category;
import com.chhaya.model.dto.Product;
import com.chhaya.utils.IOUtils;
import com.chhaya.utils.MsgUtils;
import com.chhaya.utils.constants.ProductConstants;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.sql.Date;


public class ProductView {

    private ProductController productController;

    public void setProductController(ProductController productController) {
        this.productController = productController;
    }

    public Product insertProductView() {
        int id = IOUtils.inputInteger(ProductConstants.ENTER_PRODUCT_FIELD("ID"));
        String name = IOUtils.inputString(ProductConstants.ENTER_PRODUCT_FIELD("name"));
        int qty = IOUtils.inputInteger(ProductConstants.ENTER_PRODUCT_FIELD("qty"));
        double price = IOUtils.inputDouble(ProductConstants.ENTER_PRODUCT_FIELD("price"));
        Date importedDate = new Date(System.currentTimeMillis());

        int categoryId;
        Category category = null;
        do {
            categoryId = IOUtils.inputInteger(ProductConstants.ENTER_PRODUCT_FIELD("category ID"));
            if (categoryId < 0) {
                MsgUtils.showMsg("WARNING", "ID must be positive");
                continue;
            }
            category = productController.getCategoryById(categoryId);
            if (category == null) {
                MsgUtils.showMsg("WARNING", "Category not found");
            }
        } while (category == null);

        return new Product(id, name, qty, price, importedDate, category);
    }

    public void displayOneProductView(Product product) {
        Table table = new Table(2, BorderStyle.CLASSIC, ShownBorders.SURROUND);
        table.setColumnWidth(0, 20, 20);
        table.setColumnWidth(1, 36, 36);
        table.addCell("ID");
        table.addCell(product.getId() + "");
        table.addCell("NAME");
        table.addCell(product.getName());
        table.addCell("QTY");
        table.addCell(product.getQty() + "");
        table.addCell("PRICE");
        table.addCell(product.getPrice() + "");
        table.addCell("DATE");
        table.addCell(product.getImportedDate() + "");
        table.addCell("Category");
        table.addCell(product.getCategory().getName());
        System.out.println(table.render());
    }

}
