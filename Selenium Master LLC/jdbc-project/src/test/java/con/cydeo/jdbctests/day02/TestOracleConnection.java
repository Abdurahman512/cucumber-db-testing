package con.cydeo.jdbctests.day02;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Target;
import java.sql.*;

public class TestOracleConnection {
    String dbUrl = "jdbc:oracle:thin:@3.91.96.199:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void testconnection() throws SQLException {
        // DriverManager class help us to create connection with the help getConnection method
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        // it helps us to execute queries
        Statement statement = connection.createStatement();
        // Resultset object will store data after execution, it stores only data
        ResultSet resultSet = statement.executeQuery("select * from regions");

/*
       resultSet.next();   // true --> if the new current row valid, false if there are no more rows

        // COLUMNINDEX    COLUMNLABEL
        System.out.println("First row id with index "+ resultSet.getString(1));
        System.out.println("First row id with column label "+ resultSet.getString("region_id"));

        // get me first row region name
        System.out.println("First row region name "+resultSet.getString(2));
        System.out.println(resultSet.getString("region_name"));

        System.out.println("***************");
        System.out.println("First row id: "+resultSet.getString(1)+" name_ "+resultSet.getString(2));

        // Secound Row 2 _ Americas
        resultSet.next();
        System.out.println("Secound row id: "+resultSet.getString(1)+" name_ "+resultSet.getString(2));
        // Third Row 3 _ Asia
        resultSet.next();
        System.out.println("Third row id: "+resultSet.getString(1)+" name_ "+resultSet.getString(2));
        // Fourth Row 4 _ Middle East and Africa
        resultSet.next();
        System.out.println("Fourth row id: "+resultSet.getString(1)+" name_ "+resultSet.getString(2));
        */

        // what if we have 1000 line in result set?

        while (resultSet.next()){
            System.out.println("id "+resultSet.getString(1)+" name> "+ resultSet.getString(2));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
