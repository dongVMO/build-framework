package saucedemo.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/saucedemo/features",
        glue = "core.saucedemo.actions.stepdefinitions",
//        dryRun = false,
        monochrome = true,
        tags = "@login"
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}

