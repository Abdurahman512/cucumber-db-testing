package excelOperations;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFormulaCell {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Numbers");
        XSSFRow row = sheet.createRow(0);

        row.createCell(0).setCellValue(100);
        row.createCell(1).setCellValue(200);
        row.createCell(2).setCellValue(300);

        row.createCell(3).setCellFormula("A1+B1+C1");

        FileOutputStream outputStream = new FileOutputStream("src/test/resources/calc..xlsx");
        workbook.write(outputStream);

        outputStream.close();

        System.out.println("calc.xlsx created with formula cell ...");
    }
}
