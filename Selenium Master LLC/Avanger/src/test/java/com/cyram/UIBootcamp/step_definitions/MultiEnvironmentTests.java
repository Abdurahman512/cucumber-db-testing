package com.cyram.UIBootcamp.step_definitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;

public class MultiEnvironmentTests {

    @Then("Spartan names from UI and DB should match")
    public void spartan_names_from_ui_and_db_should_match() {

        System.out.println("new SpartanDB_Steps().DBname = " + new SpartanDB_Steps().DBname);
        System.out.println("new SpartanUI_Steps().UIname = " + new SpartanUI_Steps().UIname);

        Assert.assertEquals(new SpartanDB_Steps().DBname,new SpartanUI_Steps().UIname);


    }
}
