package con.cydeo.jdbctests.day02;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfMap {
    String dbUrl = "jdbc:oracle:thin:@3.91.96.199:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void liftOfMap() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select first_name, last_name, salary from employees");

        // ResultSetMetaData
        ResultSetMetaData rsMetadata = resultSet.getMetaData();

        // create a list to put maps for each row
        List<Map<String, Object>> dataList = new ArrayList<>();

        // iterate each row
        while (resultSet.next()){
            // store data for that row into map
            Map<String , Object> rowMap = new HashMap<>();
            for (int i = 1; i <= rsMetadata.getColumnCount(); i++) {
                rowMap.put(rsMetadata.getColumnName(i),resultSet.getString(i));
            }
            dataList.add(rowMap);
        }
        System.out.println("*** Print all data from query ***");
        for (Map<String, Object> eachRow : dataList) {
            System.out.println(eachRow);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
