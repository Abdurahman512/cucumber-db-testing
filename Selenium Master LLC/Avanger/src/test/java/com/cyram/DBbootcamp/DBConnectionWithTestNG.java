package com.cyram.DBbootcamp;

import com.cyram.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DBConnectionWithTestNG {

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    String query = "select name from SPARTANS  where spartan_id = 24 ";

    @BeforeMethod
    public void connectToDB() throws SQLException {

        connection = DriverManager.getConnection(ConfigurationReader.get("spartan.DBUrl"),
                ConfigurationReader.get("spartan.DBusername"), ConfigurationReader.get("spartan.DBpassword"));
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);
    }

    @AfterMethod
    public void closeDBconnection() throws SQLException {

        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    public void test1() throws SQLException {

        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }
    }

    @Test
    public void test2() throws SQLException {

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        Map<String, Object> row = new HashMap<>();
        while (resultSet.next()){
            String result = "";
            for (int i = 1; i <= columnCount ; i++) {

                row.put(metaData.getColumnName(i), resultSet.getObject(i));
               result += " "+resultSet.getString(i);
            }
            System.out.println("result = " + result);
            System.out.println("row = " + row);
        }
    }
    @Test
    public void test3(){


    }
}
