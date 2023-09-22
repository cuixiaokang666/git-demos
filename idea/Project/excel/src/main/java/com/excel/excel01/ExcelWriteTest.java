package com.excel.excel01;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ExcelWriteTest {
    @Test
    public void testWrite03() throws IOException {
        //创建一个工作簿
        Workbook workbook = new HSSFWorkbook();
        //创建一个工作表
        Sheet sheet = workbook.createSheet("Sheet1");
        //创建行
        Row row = sheet.createRow(2);
        //创建单元格
        Cell cell = row.createCell(2);
        cell.setCellValue("你好,崔晓抗");
        //创建输出流对象
        OutputStream out = new FileOutputStream("D:/abc.xls");
        //将数据通过输出流写出
        workbook.write(out);
        //关闭流,释放资源
        out.close();
        System.out.println("执行完成");
    }

    @Test
    public void testWrite07() throws IOException {
        //创建工作簿对象
        Workbook workbook = new XSSFWorkbook();
        //创建一个工作表
        Sheet sheet = workbook.createSheet("用户信息1");
        //创建行
        Row row = sheet.createRow(0);
        //创建单元格
        Cell cell = row.createCell(0);
        String s = new DateTime().toString("yyyy-MM-dd");
        cell.setCellValue(s);
        //创建输出流对象
        OutputStream out = new FileOutputStream("D:/abc.xlsx");
        //将数据通过输出流写出
        workbook.write(out);
        //关闭流,释放资源
        out.close();
        System.out.println("执行成功");
    }

}
