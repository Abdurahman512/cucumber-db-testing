package excelOperations;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class WritingExcelDemo1 {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Employees Info");
/*
        Object employeeData [][] = {
                {"EmpID", "Name", "Job"},
                {101,"David","Enginner"},
                {102,"Smith","Manager"},
                {103,"Scoot","Analyst"}
        };

        // Using for loop
        int rows = employeeData.length;
        int cols = employeeData[0].length;

        System.out.println(rows);  //4
        System.out.println(cols);  //3

        for (int r=0; r<rows; r++)
        {
            XSSFRow row = sheet.createRow(r);   // create row

            for (int c=0; c<cols; c++)
            {
                XSSFCell cell = row.createCell(c);  // 0 cell created
               Object value = employeeData [r][c];

               if (value instanceof String)
                 cell.setCellValue((String) value);

               if (value instanceof Integer)
                   cell.setCellValue((Integer) value);

                if (value instanceof Boolean)
                    cell.setCellValue((Boolean) value);

            }
        }

 */

        ArrayList<Object[]> employeeData = new ArrayList<Object[]>();
        employeeData.add(new Object[] {"EmpID","Name","Job"});
        employeeData.add(new Object[]{101,"David","Enginner"});
        employeeData.add(new Object[]{102,"Smith","Manager"});
        employeeData.add(new Object[]{103,"Scott","Analyst"});

        // Using for each loop
        int rowCount = 0;
        for (Object emp[] : employeeData)
        {
            XSSFRow row = sheet.createRow(rowCount++);

            int columnCount = 0;
            for (Object value :emp)
            {
             XSSFCell cell = row.createCell(columnCount++);

                if (value instanceof String)
                    cell.setCellValue((String) value);

                if (value instanceof Integer)
                    cell.setCellValue((Integer) value);

                if (value instanceof Boolean)
                    cell.setCellValue((Boolean) value);
            }
        }
        String filePath = "src/test/resources/employee.xlsx";
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);

        outputStream.close();

        System.out.println("Employee.xls file written  successfully");

    }
}
