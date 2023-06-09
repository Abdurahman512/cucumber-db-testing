package con.cydeo.jdbctests.day01;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class TestOracleConnection1 {

    // INSTEAD OF THIS URL USE YOUR IP FROM EC2 INSTANCE
    String dbURL ="jdbc:oracle:thin:@3.91.96.199:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";
    @Test
    public void testConnection() throws SQLException {

        Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from regions");
/*

        // GET ME FIRST ROW REGION ID
        resultSet.next();
        System.out.println("First roe info ");

        // ColumenIndex
        System.out.println("resultSet.getString(1) = " + resultSet.getString(1));
        System.out.println("resultSet.getString(\"REGION_ID\") = " + resultSet.getString("REGION_ID"));
        System.out.println("resultSet.getInt(1) = " + resultSet.getInt(1));
        System.out.println("resultSet.getInt(\"REGION_ID\") = " + resultSet.getInt("REGION_ID"));

        // GET ME REGION_NAME
        System.out.println("resultSet.getString(2) = " + resultSet.getString(2));
        System.out.println("resultSet.getString(\"REGION_NAME\") = " + resultSet.getString("REGION_NAME"));

        // second roe 2 americas
        resultSet.next();
        System.out.println("resultSet.getString(1) = " + resultSet.getString(1));
        System.out.println("resultSet.getString(\"REGION_NAME\") = " + resultSet.getString("REGION_NAME"));

        // third row 3 - Asia
        resultSet.next();
        System.out.println("resultSet.getString(\"REGION_NAME\") = " + resultSet.getString("REGION_NAME"));

        System.out.println("resultSet.getString(2) = " + "3 - " + resultSet.getString(2));
*/

        // What if we have 1000 line in result set ?

       while (resultSet.next()){
           System.out.println("--------");
           System.out.println(resultSet.getString(1) + " - " + resultSet.getString(2));
       }

        connection.close();
        statement.close();
        resultSet.close();


    }

}
