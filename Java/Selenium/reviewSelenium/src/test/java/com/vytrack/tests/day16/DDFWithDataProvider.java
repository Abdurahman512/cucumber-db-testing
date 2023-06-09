package com.vytrack.tests.day16;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {
    @DataProvider
    public Object [][] testData(){
        String [][] data = {
                {"Person of Interset","10"},{"Sherlock","9"},{"Friends","7"}
        };
        return data;
    }
    @Test(dataProvider = "testData")
    public void test(String tvShows, String rating){
        System.out.println("TvShow: has rating = " +
                "TvShow: " + tvShows + " has rating " + rating);
    }

}
