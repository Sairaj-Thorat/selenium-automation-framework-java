package com.utils;

import com.constants.FrameworkConstants;
import com.exceptions.InvalidPathForExcelFileException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public final class ExcelUtils {

    private ExcelUtils(){}

    public static List<Map<String, String>> getTestDetails(String sheetName) {
        List<Map<String, String>> list = new ArrayList<>();

        try (FileInputStream fs = new FileInputStream(FrameworkConstants.getExcelPath())) {
            XSSFWorkbook workbook = new XSSFWorkbook(fs) ;
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int lastrownum = sheet.getLastRowNum();
            int lastcolnum = sheet.getRow(0).getLastCellNum() ;

            Map<String, String> map;

            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i <= lastrownum; i++) {
                map = new HashMap<>();
                for (int j = 0; j < lastcolnum; j++) {
                    String key = formatter.formatCellValue(sheet.getRow(0).getCell(j));
                    String value = formatter.formatCellValue(sheet.getRow(i).getCell(j));
                    map.put(key, value);
                }
                list.add(map);
            }
        }
        catch (FileNotFoundException e) {
            throw new InvalidPathForExcelFileException("Excel file not found");
        }
        catch (IOException e){
            throw new InvalidPathForExcelFileException("Some error in I/O using Excel file.");
        }
        return list;
    }

}
