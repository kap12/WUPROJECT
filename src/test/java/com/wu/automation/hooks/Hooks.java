package com.wu.automation.hooks;

import com.wu.automation.utilities.DriverManager;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    private static boolean initialized = false;
    
    @Before(order = 0)
    public void setUp(Scenario scenario) {
        if (!initialized) {
            DriverManager.getDriver();
            initialized = true;
        }
    }
    
    @After(order = 0)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver())
                .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }
    
    @AfterAll
    public static void afterAll() {
        DriverManager.quitDriver();
    }
}