package con.cydeo.jdbctests.day01;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class MetadataTest {

    // INSTEAD OF THIS URL USE YOUR IP FROM EC2 INSTANCE
    String dbURL = "jdbc:oracle:thin:@3.91.96.199:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void testConnection() throws SQLException {

        Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select FIRST_NAME, LAST_NAME,SALARY from EMPLOYEES");

        // Database Metadata --> it is information about database itself
        DatabaseMetaData dbMetaData = connection.getMetaData();
        System.out.println("dbMetaData.getUserName() = " + dbMetaData.getUserName());
        System.out.println("dbMetaData.getDriverVersion() = " + dbMetaData.getDriverVersion());
        System.out.println("dbMetaData.getDriverName() = " + dbMetaData.getDriverName());
        System.out.println("dbMetaData.getDatabaseProductName() = " + dbMetaData.getDatabaseProductName());

        // Result set Metadata --> it provides info about table upper side(colmunName or colmunCount)
        ResultSetMetaData rsmd = resultSet.getMetaData();

        // how many colmun we have
        int columnCount = rsmd.getColumnCount();
        System.out.println(columnCount);

        // what is the name of second colmun
        System.out.println("rsmd.getColumnName(2) = " + rsmd.getColumnName(2));

        // can we get all column names
        for (int i=1; i<=3; i++){
            System.out.println(rsmd.getColumnName(i));
        }

        /*
        how to get data dynamically from any query

        ResultSet --> it holds table data
        resultSet.next()  --> to iterate each row dynamiclly
        resultSet.getString(columnIndex)  --> will give info about this cell
        resultSet.getString(columnLabel)

        ResultSetMetaData  -->  it holds table info (colmunCount / colmunName)
        rsmd.getColmunCount()  --> will give how many colmun we have
        rsmd.getColmunName()   --> will give colmun name

         */

        System.out.println("******PRINT ALL DATA DYNAMICLLY*****");
        // FIRST_NAME - Steven   LAST_NAME - King     SALARY - 24000

        // iterate each row
        while (resultSet.next()){
            // iterte each colmun
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rsmd.getColumnName(i)+" - "+resultSet.getString(i)+" ");
            }
            System.out.println();
        }





        connection.close();
        statement.close();
        resultSet.close();
    }
}
