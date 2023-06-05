package saucedemo.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "com.epam.reportportal.cucumber.ScenarioReporter"},
        features = "src/test/resources/saucedemo/features",
        glue = "core.saucedemo.actions.stepdefinitions",
//        dryRun = false,
        monochrome = true,
        tags = "@login",
        strict = true

)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}

