package Utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.util.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Excel_IO {


    static XSSFRow row;

    public Excel_IO(){

    }

    public void create_exceldocument(String filename) throws Exception{

        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet spreadsheet = workbook.createSheet(" Employee Info ");

        //Create row object
        XSSFRow row;

        //This data needs to be written (Object[])
        Map< String, Object[] > empinfo =
                new TreeMap< String, Object[] >();
        empinfo.put( "1", new Object[] { "EMP ID", "EMP NAME", "DESIGNATION" });
        empinfo.put( "2", new Object[] { "tp01", "Gopal", "Technical Manager" });
        empinfo.put( "3", new Object[] { "tp02", "Manisha", "Proof Reader" });
        empinfo.put( "4", new Object[] { "tp03", "Masthan", "Technical Writer" });
        empinfo.put( "5", new Object[] { "tp04", "Satish", "Technical Writer" });
        empinfo.put( "6", new Object[] { "tp05", "Krishna", "Technical Writer" });

        //Iterate over data and write to sheet
        Set< String > keyid = empinfo.keySet();
        int rowid = 0;

        for (String key : keyid) {
            row = spreadsheet.createRow(rowid++);
            Object [] objectArr = empinfo.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }

        String path = System.getProperty("user.dir") + "\\ExcelData\\" + filename + ".xlsx";
        System.out.println(path);
        //Create file system using specific name
        FileOutputStream out = new FileOutputStream(new File(path));

        workbook.write(out);
        out.close();
        System.out.println("Writesheet.xlsx written successfully");
    }

    public ArrayList<ArrayList<String>> open_exceldocument(String filename) throws Exception{

        String path = System.getProperty("user.dir") + "\\ExcelData\\" + filename + ".xlsx";

        FileInputStream fis = new FileInputStream(new File(path));

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet spreadsheet = workbook.getSheetAt(0);
        Iterator < Row >  rowIterator = spreadsheet.iterator();

        ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();

        ArrayList<String> tmp_row = new ArrayList<String>();

        while (rowIterator.hasNext()) {
            row = (XSSFRow) rowIterator.next();
            Iterator < Cell >  cellIterator = row.cellIterator();

            while ( cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                        tmp_row.add(cell.getNumericCellValue() + "");
                        break;

                    case Cell.CELL_TYPE_STRING:
                        tmp_row.add(cell.getStringCellValue());
                        break;
                }
            }
            output.add((ArrayList) tmp_row.clone());
            tmp_row.clear();
        }
        fis.close();

        return output;
    }

}
