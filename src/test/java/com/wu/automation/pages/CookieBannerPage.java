package com.wu.automation.pages;

import java.util.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CookieBannerPage extends BasePage {

	@FindBy(id = "onetrust-accept-btn-handler")
	private WebElement agreeButton;

	@FindBy(id = "onetrust-banner-sdk")
	private WebElement cookieBanner;

	public void acceptCookies() {
        try {
            if (isDisplayed(cookieBanner)) {
                agreeButton.click();
            }
        } catch (NoSuchElementException ignored) {
            // Silently handle if no cookie banner
        }
    }

	public boolean isCookieBannerDisplayed() {
		try {
			return cookieBanner.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}