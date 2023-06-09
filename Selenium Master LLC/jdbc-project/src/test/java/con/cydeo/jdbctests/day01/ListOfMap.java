package con.cydeo.jdbctests.day01;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfMap {

    // INSTEAD OF THIS URL USE YOUR IP FROM EC2 INSTANCE
    String dbURL = "jdbc:oracle:thin:@3.91.96.199:1521:xe";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void listOfMap() throws SQLException {

        Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from regions");

        // ResultSetMetaData
        ResultSetMetaData rsmd = resultSet.getMetaData();

        // create a list to put maps each row
        List<Map<String,Object>> dataList = new ArrayList<>();

        // iterate each row
        while (resultSet.next()){
            // store data for that row into one map
            Map<String, Object> rowMap = new HashMap<>();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                rowMap.put(rsmd.getColumnName(i),resultSet.getString(i));
            }

            dataList.add(rowMap);

        }

        System.out.println("*** Print All Data From Any Query ***");
        for (Map<String, Object> eachRow : dataList) {
            System.out.println(eachRow);
        }

        connection.close();
        statement.close();
        resultSet.close();
    }
}