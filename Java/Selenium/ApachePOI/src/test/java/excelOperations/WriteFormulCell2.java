package excelOperations;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFormulCell2 {
    public static void main(String[] args) throws IOException {

        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/Book1.xlsx";
        String fullPath = projectPath+"/"+filePath;

        FileInputStream inputStream = new FileInputStream(fullPath);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        sheet.getRow(7).getCell(2).setCellFormula("SUM(C2:C6)");
        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(fullPath);
        workbook.write(outputStream);

        workbook.close();
        outputStream.close();

        System.out.println("Done");

    }
}
