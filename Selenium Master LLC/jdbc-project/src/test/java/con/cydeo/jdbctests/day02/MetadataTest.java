package con.cydeo.jdbctests.day02;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class MetadataTest {
    String dbUrl = "jdbc:oracle:thin:@3.91.96.199:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void metadataTest() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select first_name, last_name, salary from employees");

        // Database Metadata  --> it is information about database itself
        DatabaseMetaData dbMetadata = connection.getMetaData();
        System.out.println(dbMetadata.getUserName());
        System.out.println(dbMetadata.getDriverVersion());
        System.out.println(dbMetadata.getDriverName());
        System.out.println(dbMetadata.getDatabaseProductName());

        // ResultSet Metadata --> it provides information about table upper side (columnName or columnCount)
        ResultSetMetaData rsMetaData = resultSet.getMetaData();

        // how many column we have?
        int columnCount = rsMetaData.getColumnCount();
        System.out.println("Column "+columnCount);

        // what is the name of secound column?
        System.out.println(rsMetaData.getColumnName(2));

        // can we get all column name?
        for (int i = 1; i <= columnCount; i++) {
            System.out.println(rsMetaData.getColumnName(i));
        }

        System.out.println("print all data dynamically");
        // iterate each row
        while (resultSet.next()){
            // iterate each column
            for (int i = 1; i <= columnCount; i++) {
                // first_name Steven   last_name   King    Salary  24000
                // first_name Neena   last_name   Kocchar    Salary  17000
                System.out.print(rsMetaData.getColumnName(i)+"-"+resultSet.getString(i));
            }
            System.out.println();
        }



        resultSet.close();
        statement.close();
        connection.close();
    }
}
