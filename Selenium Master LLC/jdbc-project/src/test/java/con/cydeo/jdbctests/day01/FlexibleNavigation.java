package con.cydeo.jdbctests.day01;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class FlexibleNavigation {


    // INSTEAD OF THIS URL USE YOUR IP FROM EC2 INSTANCE
    String dbURL = "jdbc:oracle:thin:@3.91.96.199:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void testConnection() throws SQLException {

        Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select FIRST_NAME, LAST_NAME from EMPLOYEES");

        // get me first row info
        resultSet.next();
        System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));

        // get me second row info
        resultSet.next();
        System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));

        // get me last row info
        resultSet.last();
        System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));

        // how many roe we have?
        System.out.println(resultSet.getRow());

        // get data from row 8
        resultSet.absolute(8);
        System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
        System.out.println(resultSet.getRow());

        resultSet.previous();
        System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
        System.out.println(resultSet.getRow());

        System.out.println(" *********************************+");
        resultSet.beforeFirst();
        // how to print all result set info
        while (resultSet.next()){
            System.out.println(resultSet.getRow()+" - "+resultSet.getString(1) + " " + resultSet.getString(2));

        }





        connection.close();
        statement.close();
        resultSet.close();
    }
}