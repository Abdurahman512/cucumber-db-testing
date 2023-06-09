package excelOperations;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadDataFromFormulaCell {
    public static void main(String[] args) throws IOException {

        String path = "src/test/resources/readformula.xlsx";
        String projectPath = System.getProperty("user.dir");
        String fullPath = projectPath+"/"+path;

        FileInputStream file = new FileInputStream(fullPath);

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rows = sheet.getLastRowNum();
        int colmuns = sheet.getRow(0).getLastCellNum();

        for (int r=0; r<=rows; r++)
        {
            XSSFRow row = sheet.getRow(r);
            for (int c=0; c<colmuns; c++)
            {
                XSSFCell cell = row.getCell(c);

                switch (cell.getCellType())
                {
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
                System.out.print(" | ");
            }
            System.out.println();
        }
        file.close();

    }
}
