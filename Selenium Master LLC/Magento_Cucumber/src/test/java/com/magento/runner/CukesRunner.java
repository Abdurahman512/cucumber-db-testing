package com.magento.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "rerun:target/rerun.txt",
        },
        features = "src/test/resources/feutures",
        glue = "com/magento/stepdifinitions",
        dryRun = false,
        tags = "@MarketingManagerCanAddNewCatalogPriceRule"
)
public class CukesRunner {
}
