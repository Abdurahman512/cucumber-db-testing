package con.cydeo.jdbctests.day02;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class FlexibleNavigation {

    String dbUrl = "jdbc:oracle:thin:@3.91.96.199:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void flexibleNavigation() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select first_name, last_name from employees");
/*
        // get me first row information
        resultSet.next();
        System.out.println("First_name "+resultSet.getString(1)+", last_name "+resultSet.getString(2));

        // get me secound row info
        resultSet.next();
        System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));

        // get me last row info
        resultSet.last();
        System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));

        // how many row we have?
        System.out.println("How many rows "+resultSet.getRow());

        // get data from row 8
        resultSet.last();
        System.out.println("Row 8 "+resultSet.absolute(8));
        System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));

        // previous
        resultSet.previous();
        System.out.println(resultSet.getString(1)+" "+resultSet.getString(2));
*/
        resultSet.beforeFirst();

        // how to print all result set info

        System.out.println("how to print all result set info");
        while (resultSet.next()){
            System.out.println(resultSet.getRow()+"-"+resultSet.getString(1)+" "+resultSet.getString(2));
        }
        resultSet.close();
        statement.close();
        connection.close();

    }
}
