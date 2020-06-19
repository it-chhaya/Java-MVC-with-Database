package com.chhaya.view;

import com.chhaya.model.dto.Category;
import com.chhaya.utils.IOUtils;
import com.chhaya.utils.Pagination;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;

public class CategoryView {

    public Category saveCategoryView() {
        int id = IOUtils.inputInteger("Enter category ID > ");
        String name = IOUtils.inputString("Enter category name > ");
        return new Category(id, name);
    }

    public int findCategoryByIdView() {
       return IOUtils.inputInteger("Enter category ID > ");
    }

    public String findCategoriesByNameView() {
        return IOUtils.inputString("Enter category NAME > ");
    }

    public Category updateCategoryView() {
        int id = IOUtils.inputInteger("Enter category ID > ");
        String name = IOUtils.inputString("Enter category name > ");
        return new Category(id, name);
    }

    public void displayCategories(List<Category> categories, Pagination paging) {

        Table body = new Table(2, BorderStyle.CLASSIC, ShownBorders.ALL);
        CellStyle alignRight = new CellStyle(CellStyle.HorizontalAlign.right);

        body.setColumnWidth(0, 15, 15);
        body.setColumnWidth(1, 41, 41);

        body.addCell("ID");
        body.addCell("NAME");

        for (Category category : categories) {
            body.addCell(category.getId() + "");
            body.addCell(category.getName());
        }

        body.addCell("PAGE: " + paging.getPage() + "/" + paging.getTotalPages());
        body.addCell("RECORDS: " + paging.getTotalRecords(), alignRight);

        System.out.println(body.render());

    }

    public void displayOneCategoryView(Category category) {
        Table table = new Table(2, BorderStyle.CLASSIC, ShownBorders.ALL);
        table.setColumnWidth(0, 20, 20);
        table.setColumnWidth(1, 36, 36);
        table.addCell("ID");
        table.addCell(category.getId() + "");
        table.addCell("NAME");
        table.addCell(category.getName());
        System.out.println(table.render());
    }

    public int gotoPageView() {
        return IOUtils.inputInteger("Enter page to go > ");
    }

}
