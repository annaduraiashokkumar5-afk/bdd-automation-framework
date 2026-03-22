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

    public static List<String> getColumnValues(String filePath, String sheetName, int columnIndex) {
        List<String> columnData = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                System.out.println("Sheet not found");
                return columnData;
            }

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {   // start from 1 to skip header
                Row row = sheet.getRow(i);

                if (row != null) {
                    Cell cell = row.getCell(columnIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    columnData.add(cell.toString());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return columnData;
    }
    }

