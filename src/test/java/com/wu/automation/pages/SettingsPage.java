package com.wu.automation.pages;

import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SettingsPage extends BasePage {
    
    @FindBy(id = "Question")
    private WebElement countryDropdown;
    
    @FindBy(xpath = "//button[contains(., 'Yes') or contains(., 'Confirm')]")
    private WebElement confirmButton;
    
    @FindBy(id = "settingsPageHeader")
    private WebElement pageHeader;

    public void confirmCountryChange() {
        click(confirmButton);
    }

    private static final Map<String, String> COUNTRY_MAPPING = Map.of(
    	    "USA", "United States",
    	    "Lithuania", "Lithuania"
    	    // Add other common mappings
    	);

    	public void selectCountry(String country) {
    	    Select dropdown = new Select(countryDropdown);
    	    String exactCountry = COUNTRY_MAPPING.getOrDefault(country, country);
    	    
    	    try {
    	        dropdown.selectByVisibleText(exactCountry);
    	    } catch (NoSuchElementException e) {
    	        throw new RuntimeException("Country not found in dropdown: " + exactCountry);
    	    }
    	}
}