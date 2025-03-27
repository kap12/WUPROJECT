package com.wu.automation.pages;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindLocationsPage extends BasePage {

	@FindBy(id = "input_location_selection")
	private WebElement locationSearchField;

	@FindBy(id = "icon_search")
	private WebElement searchButton;

	@FindBy(id = "filter_open_now")
	private WebElement openButton;

	@FindBy(id = "label_find_location_location_address_city")
	private WebElement firstLocationAddress;

	@FindBy(css = "ul.FindLocation_agentsLists__ikkyi > li")
	private List<WebElement> locationItems;

	public String getFirstLocationAddress() {
		// Use JavaScript to directly query the DOM for the first address
		return (String) ((JavascriptExecutor) driver).executeScript(
				"return document.querySelector('ul.FindLocation_agentsLists__ikkyi > li:nth-child(2) p[aria-label]')?.ariaLabel || ''");
	}

	public boolean isPageLoaded() {
		// Use JavaScript executor for faster DOM state check
		return (Boolean) ((JavascriptExecutor) driver).executeScript("return document.readyState === 'complete' && "
				+ "document.querySelector('#input_location_selection') !== null");
	}

	public void clearLocationSearchField() {
		locationSearchField.clear();
		locationSearchField.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all text
		locationSearchField.sendKeys(Keys.DELETE); // Delete selection
	}

	public void enterLocationSearch(String zipCode) {
		sendKeys(locationSearchField, zipCode);
	}

	public void clickSearchButton() {
		click(searchButton);
	}

	public void clickOpenButton() {
		click(openButton);
	}

}