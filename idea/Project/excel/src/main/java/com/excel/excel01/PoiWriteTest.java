package com.excel.excel01;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PoiWriteTest {
    @Test
    public void test03() throws IOException {
        long stat = System.currentTimeMillis();
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        for(int i=0;i<65500;i++){
            Row row = sheet.createRow(i);
            for(int j=0;j<10;j++){
                Cell cell = row.createCell(j);
                cell.setCellValue(i+j);
            }
        }
        //创建输出流对象
        OutputStream out = new FileOutputStream("D:/abc.xls");
        //将数据通过输出流写出
        workbook.write(out);
        //关闭流,释放资源
        out.close();
        long end = System.currentTimeMillis();
        System.out.println("POI03版写出数据用时:"+(end - stat));
    }
    @Test
    public void test07() throws IOException {
        long stat = System.currentTimeMillis();
        Workbook workbook = new SXSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        for(int i=0;i<65500;i++){
            Row row = sheet.createRow(i);
            for(int j=0;j<10;j++){
                Cell cell = row.createCell(j);
                cell.setCellValue(i+j);
            }
        }
        //创建输出流对象
        OutputStream out = new FileOutputStream("D:/abc.xlsx");
        //将数据通过输出流写出
        workbook.write(out);
        //关闭流,释放资源
        out.close();
        long end = System.currentTimeMillis();
        //清理临时文件
        ((SXSSFWorkbook)workbook).dispose();
        System.out.println("POI07版写出数据用时:" + (end - stat));
    }
}
