package com.excel.excel02;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class ExcelReadTest {

    @Test
    public void testRead03() throws IOException {

        //获取文件流
        FileInputStream fileInputStream = new FileInputStream("D:/xyz.xls");
        //获取工作簿
        Workbook workbook = new HSSFWorkbook(fileInputStream);
        //获取工作表
        Sheet sheet = workbook.getSheetAt(0);
        //获取行
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        String stringCellValue = cell.getStringCellValue();
        System.out.println(stringCellValue);
        fileInputStream.close();
    }

    @Test
    public void testRead07() throws IOException {
        //获取文件流
        FileInputStream fileInputStream = new FileInputStream("D:/abc.xlsx");
        //获取工作簿
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        //获取工作表
        Sheet sheet = workbook.getSheetAt(0);
        //获取行
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        String stringCellValue = cell.getStringCellValue();
        System.out.println(stringCellValue);
        fileInputStream.close();
    }

    @Test
    public void testCellType() throws IOException {
        //获取文件流
        FileInputStream fileInputStream = new FileInputStream("D:/xyz.xls");
        //获取工作簿
        Workbook workbook = new HSSFWorkbook(fileInputStream);
        //获取工作表
        Sheet sheetAt = workbook.getSheetAt(0);
        //获取表头
        Row row = sheetAt.getRow(0);
        if (row != null) {
            //获取标题长度
            int len = row.getPhysicalNumberOfCells();
            for (int i = 0; i < len; i++) {
                //拿到单元格
                Cell cell = row.getCell(i);
                if (cell != null) {
                    String stringCellValue = cell.getStringCellValue();
                    System.out.print(stringCellValue + "|");
                }
            }
        }
        //换行输出
        System.out.println();
        //获取所有行
        int physicalNumberOfRows = sheetAt.getPhysicalNumberOfRows();
        for (int i = 1; i < physicalNumberOfRows; i++) {
            Row row1 = sheetAt.getRow(i);
            if (row1 != null) {
                //获取当前行所有单元格数量
                int phy = row1.getPhysicalNumberOfCells();
                for (int j = 0; j < phy; j++) {
                    Cell cell = row1.getCell(j);
                    if (cell != null) {
                        //获取单元格的数据类型
                        CellType cellTypeEnum = cell.getCellTypeEnum();
                        String cellValue = "";
                        switch (cellTypeEnum) {
                            //位置类型,用于表达初始化前的状态或缺少具体类型,仅供内部使用
                            case _NONE:
                                System.out.print("位置类型");
                                break;
                            //数值类型,小数,整数,日期
                            case NUMERIC:
                                //如果是数字类型,判断是不是日期类型
                                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                    //获取单元格的值
                                    Date dateCellValue = cell.getDateCellValue();
                                    cellValue = new DateTime(dateCellValue).toString("yyyy-MM-dd");
                                    System.out.print("日期");
                                } else {
                                    //如果是小数,或者整数,防止数字过长,将其转成字符串进行获取
                                    cell.setCellType(cellTypeEnum.STRING);
                                    cellValue = cell.toString();
                                    System.out.print("小数或整数转成字符串");
                                }
                                break;
                            //字符串类型
                            case STRING:
                                cellValue = cell.getStringCellValue();
                                System.out.print("字符串");
                                break;
                            //公式
                            case FORMULA:
                                cellValue = cell.getCellFormula();
                                System.out.print("公式");
                                break;
                            case BLANK:
                                System.out.print("空白的单元格");
                                break;
                            case ERROR:
                                System.out.print("错误类型");
                                break;
                            case BOOLEAN:
                                cellValue = cell.getBooleanCellValue() + "";
                                System.out.print("布尔类型");
                        }
                        System.out.print("数据为:" + cellValue + "|");
                    }
                }
                System.out.println();
            }
        }
        fileInputStream.close();
    }
}
