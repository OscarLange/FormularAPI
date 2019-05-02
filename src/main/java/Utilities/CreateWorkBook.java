package Utilities;

import java.io.*;
import org.apache.poi.xssf.usermodel.*;

public class CreateWorkBook {
    public void createworkbook(String filename)throws Exception {
        //Create Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        String path = System.getProperty("user.dir") + "\\ExcelData\\" + filename + ".xlsx";
        System.out.println(path);
        //Create file system using specific name
        FileOutputStream out = new FileOutputStream(new File(path));

        //write operation workbook using file out object
        workbook.write(out);
        out.close();
        System.out.println("createworkbook.xlsx written successfully");
    }
}
