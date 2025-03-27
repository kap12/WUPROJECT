package com.wu.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;

@CucumberOptions(
    features = "src/test/resources/features/pay_bills.feature",
    glue = {"com.wu.automation.stepdefinitions", "com.wu.automation.hooks"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json"
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @AfterSuite
    public void tearDownSuite() {
    }
}