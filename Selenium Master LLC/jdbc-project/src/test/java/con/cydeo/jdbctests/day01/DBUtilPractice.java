package con.cydeo.jdbctests.day01;

import con.cydeo.jdbctests.utilities.DBUtils;
import org.junit.jupiter.api.Test;

public class DBUtilPractice {

    @Test
    public void dbUtilPractice(){

        //create connection
        DBUtils.createConnection();

        // run query
        DBUtils.runQuery("select first_name, last_name, salary from employees");

        // get me first row first colmun  --> Steven


    }

}
