package com.visionet.word.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

public class ExcelTest {

    @Test
    public void test() {
        try {
            // 打开指定位置的Excel文件
            FileInputStream file = new FileInputStream(new File("C:\\Users\\bai\\Desktop\\528.xls"));
            Workbook workbook = new XSSFWorkbook(file);
            // 打开Excel中的第一个Sheet
            Sheet sheet = workbook.getSheetAt(0);

            // 行
            for (Row row : sheet) {
                row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                System.out.println(row.getCell(0).getStringCellValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
