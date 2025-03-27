package com.wu.automation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.wu.automation.utilities.BrowserUtils;

public class PayBillsPage extends BasePage {

    @FindBy(id = "companyName")
    private WebElement billerSearchField;
    
    @FindBy(id = "amount")
    private WebElement sendAmountField;

    @FindBy(id = "billerNumber")
    private WebElement accountNumberField;

    @FindBy(css = "button[amplitude-id='button-bpstart-continue']")
    private WebElement continueButton;

    @FindBy(id = "billPayFundsIn_AG")
    private WebElement payInStoreButton;

    @FindBy(id = "billPayDeliveryService_000")
    private WebElement deliveryServiceSelect;

    @FindBy(id = "eflState")
    private WebElement stateDropdown;

    public void searchForBiller(String billerName) {
        sendKeys(billerSearchField, billerName);
        billerSearchField.sendKeys(Keys.ENTER);
    }
    
    public void enterSendAmount(String amount) {
        sendKeys(sendAmountField, amount);
    }

    public void enterAccountNumber(String accountNumber) {
        sendKeys(accountNumberField, accountNumber);
    }

    public void clickContinue() {
        if (!continueButton.isDisplayed()) {
            BrowserUtils.scrollToElement(driver, continueButton);
        }
        click(continueButton);
    }

    public void selectPayInStore() {
        click(payInStoreButton);
    }

    public void selectDeliveryService() {
        click(deliveryServiceSelect);
    }

    public void selectStateFromDropdown(String stateName) {
        Select select = new Select(stateDropdown);
        try {
            select.selectByVisibleText(stateName);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("State not found in dropdown: " + stateName);
        }
    }
}