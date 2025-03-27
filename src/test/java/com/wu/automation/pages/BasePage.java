package com.wu.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wu.automation.utilities.DriverManager;
import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait shortWait;
    protected WebDriverWait mediumWait;
    protected WebDriverWait longWait; 

    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        this.mediumWait = new WebDriverWait(driver, Duration.ofSeconds(7));
        this.longWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Enum for wait strategies
    public enum WaitStrategy {
        SHORT, 
        MEDIUM, 
        LONG
    }

    protected WebElement waitAndFindElement(By locator, WaitStrategy strategy) {
        switch(strategy) {
            case SHORT: return shortWait.until(ExpectedConditions.presenceOfElementLocated(locator));
            case MEDIUM: return mediumWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            case LONG: return longWait.until(ExpectedConditions.elementToBeClickable(locator));
            default: throw new IllegalArgumentException("Invalid wait strategy");
        }
    }

    protected void click(WebElement element) {
        element.click();
    }

    protected void sendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    protected boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}