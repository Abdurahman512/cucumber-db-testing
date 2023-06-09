package con.cydeo.jdbctests.day02;

import con.cydeo.jdbctests.utilities.DBUtils;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class DBUtilPractice {

    @Test
    public void dbUtilsPractice(){

        // create connection
        DBUtils.createConnection();

        // run query
        DBUtils.runQuery("select first_name, last_name, salary from employees");

        System.out.println("Get me first row first column  --> Steven");
        System.out.println(DBUtils.getFirstRowFirstColumn());

        System.out.println("Get me all column name");
        System.out.println(DBUtils.getAllColumnNamesAsList());

        System.out.println("Get me all first_name name");
        System.out.println(DBUtils.getColumnDataAsList(1));

        System.out.println("Get me how many row we have");
        System.out.println(DBUtils.getRowCount());

        System.out.println("Get me all data from execution");
        List<Map<String, String>> allRowAsListOfMap = DBUtils.getAllRowAsListOfMap();
        for (Map<String, String> eachMap : allRowAsListOfMap) {
            System.out.println(eachMap);
        }

        DBUtils.destroy();


    }
}
