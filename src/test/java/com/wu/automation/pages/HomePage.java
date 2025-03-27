package com.wu.automation.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	@FindBy(id = "hamburger-nav-item")
	private WebElement burgerMenu;

	@FindBy(partialLinkText = "Settings")
	private WebElement settingsLink;

	@FindBy(linkText = "Pay bills")
	private WebElement payBillLink;

	@FindBy(linkText = "Find locations")
	private WebElement findLocationsLink;

	public void clickFindLocations() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(findLocationsLink)).click();
	}

	public void selectMenuOption(String option) {

		openBurgerMenu();

		switch (option.toLowerCase()) {
		case "settings":
			navigateToSettings();
			break;
		case "pay bill":
			navigateToPayBill();
			break;
		case "find locations":
			navigateToFindLocations();
			break;
		default:
			throw new IllegalArgumentException("Unknown menu option: " + option);
		}
	}

	public void openBurgerMenu() {
		click(burgerMenu);
	}

	public void navigateToSettings() {
		click(settingsLink);
	}

	public void navigateToPayBill() {
		click(payBillLink);
	}

	public void navigateToFindLocations() {
		click(findLocationsLink);
	}

}