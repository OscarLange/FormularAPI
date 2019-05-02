package Utilities;

import java.io.*;
import org.apache.poi.xssf.usermodel.*;

public class OpenWorkBook {
    public void openworkbook(String filename)throws Exception {

        String path = System.getProperty("user.dir") + "\\ExcelData\\" + filename + ".xlsx";

        File file = new File(path);
        FileInputStream fIP = new FileInputStream(file);

        //Get the workbook instance for XLSX file
        XSSFWorkbook workbook = new XSSFWorkbook(fIP);

        if(file.isFile() && file.exists()) {
            System.out.println("openworkbook.xlsx file open successfully.");
        } else {
            System.out.println("Error to open openworkbook.xlsx file.");
        }
    }
}
