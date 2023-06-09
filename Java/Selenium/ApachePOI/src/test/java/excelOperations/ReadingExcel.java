package excelOperations;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ReadingExcel {
    public static void main(String[] args) throws IOException {

        String path = "src/test/resources/countries.xlsx";
        String projectPath = System.getProperty("user.dir");
        String fullPath = projectPath+"/"+path;

        FileInputStream input = new FileInputStream(fullPath);

        XSSFWorkbook workbook = new XSSFWorkbook(input);

        XSSFSheet sheet = workbook.getSheet("Sheet1");
        // XSSFSheet sheet = workbook.getSheetAt(0);

        // Using for loop
        /*
        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(1).getLastCellNum();

        for (int r=0; r<=rows; r++)
        {
           XSSFRow row = sheet.getRow(r);            // get row number  0
            for (int c=0; c<cols; c++)
            {
              XSSFCell cell=  row.getCell(c);

              switch (cell.getCellType()){  // cell.getCellType() it can be String, int, boolean

                  case STRING:
                      System.out.print(cell.getStringCellValue());
                      break;
                  case NUMERIC:
                      System.out.print(cell.getNumericCellValue());
                      break;
                  case BOOLEAN:
                      System.out.print(cell.getBooleanCellValue());
                      break;
              }
                System.out.println(" | ");
            }
            System.out.println();
        }
         */

        //  Iterator

        Iterator iterator = sheet.iterator();  // iterator() get all the rows

        while (iterator.hasNext())  // is object there?
        {
         XSSFRow row = (XSSFRow) iterator.next();

            Iterator cellItrator = row.cellIterator();

            while (cellItrator.hasNext())
            {
                XSSFCell cell = (XSSFCell) cellItrator.next();

                switch (cell.getCellType()){  // cell.getCellType() it can be String, int, boolean

                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                }
                System.out.print(" / ");
            }
            System.out.println();
        }
    }
}
