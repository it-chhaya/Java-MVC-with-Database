package com.chhaya.view;

import com.chhaya.utils.IOUtils;
import com.chhaya.utils.MenuConstants;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

public class MenuView {

    public int displayMainMenu() {

        Table table = new Table(1, BorderStyle.CLASSIC, ShownBorders.SURROUND);

        table.addCell("1-" + MenuConstants.CATEGORY_MANAGEMENT);
        table.addCell("2-" +MenuConstants.PRODUCT_MANAGEMENT);
        table.addCell("3-" +MenuConstants.HELP);
        table.addCell("4-" +MenuConstants.EXIT);
        System.out.println(table.render());

        // Get input from user
        return IOUtils.inputInteger(MenuConstants.CHOOSE_OPTION_MENU);

    }

    public String displaySubMenu() {

        Table table = new Table(1, BorderStyle.CLASSIC, ShownBorders.SURROUND);

        table.addCell(MenuConstants.MANAGEMENT_MENU_LINE_1);
        table.addCell(MenuConstants.MANAGEMENT_MENU_LINE_2);

        System.out.println(table.render());

        return IOUtils.inputString(MenuConstants.CHOOSE_OPTION_MENU);

    }

}
