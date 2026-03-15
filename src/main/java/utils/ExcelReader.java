package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {

    private String filePath;

    public ExcelReader(String filePath){
        this.filePath = filePath;
    }



    public static Map<String, String> getRowData(String filePath, String sheetName, int rowNum)
            throws IOException {

        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        Row headerRow = sheet.getRow(0);
        Row dataRow = sheet.getRow(rowNum);

        Map<String, String> dataMap = new HashMap<>();

        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            String key = headerRow.getCell(i).getStringCellValue();
            String value = dataRow.getCell(i).toString();
            dataMap.put(key, value);
        }

        workbook.close();
        fis.close();

        return dataMap;
    }
    }

