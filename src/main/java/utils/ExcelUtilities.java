package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtilities {

    public static String readExcelData(String fileName, String sheetName, int rowNum,int cellNum){
        String data = "";
        File file = new File(fileName);
        try(FileInputStream fis = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(fis)){

            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(cellNum);
            data = cell.toString();

        }catch (Exception e){
            throw new RuntimeException("Error reading Excel file: " + fileName, e);
        }finally {

        }
        return data;
    }


}
