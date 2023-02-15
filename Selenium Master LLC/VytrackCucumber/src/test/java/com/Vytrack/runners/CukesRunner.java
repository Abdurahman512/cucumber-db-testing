package com.Vytrack.runners;

import io.cucumber.junit.*;
import org.junit.runner.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-reports.html",},
        features = "src/test/resources/features",
        glue = "com/Vytrack/step_definitions",
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner {
}
