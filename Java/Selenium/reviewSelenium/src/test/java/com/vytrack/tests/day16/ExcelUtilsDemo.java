package com.vytrack.tests.day16;

import com.vytrack.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {
    @Test
    public void readExcelFile(){

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata .xlsx","QA3-short");
        System.out.println("qa3short.columnCount() = " + qa3short.columnCount());
        System.out.println("qa3short.rowCount() = " + qa3short.rowCount());

        List<Map<String, String>> dataList = qa3short.getDataList();
        System.out.println("dataList.get(1) = " + dataList.get(1));
        System.out.println("dataList.size() = " + dataList.size());
        for (Map<String, String> oneRow : dataList) {
            System.out.println("oneRow = " + oneRow);
        }
        System.out.println("dataList.get(2).get(\"firstname\") = " + dataList.get(2).get("firstname"));
        System.out.println("dataList.get(8).get(\"lastname\") = " + dataList.get(8).get("lastname"));
        String [][] dataArray = qa3short.getDataArray();

    }
}
