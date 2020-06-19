package com.chhaya.utils;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

public class MsgUtils {

    public static void showMsg(String title, String msg) {
        Table table = new Table(1, BorderStyle.CLASSIC, ShownBorders.ALL);
        CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        table.setColumnWidth(0, 57,57);
        table.addCell(title, cellStyle);
        table.addCell(msg, cellStyle);
        System.out.println(table.render());
    }

}
