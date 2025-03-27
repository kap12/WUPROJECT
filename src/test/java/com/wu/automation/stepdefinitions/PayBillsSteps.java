package com.wu.automation.stepdefinitions;

import com.wu.automation.pages.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import com.wu.automation.utilities.DriverManager;

public class PayBillsSteps {
	private HomePage homePage;
	private CookieBannerPage cookieBannerPage;
	private SettingsPage settingsPage;
	private PayBillsPage payBillsPage;
	private boolean cookiesAccepted = false;

	private void initializePages() {
		if (homePage == null) {
			homePage = new HomePage();
			cookieBannerPage = new CookieBannerPage();
		}
	}

	@Given("the user opens the page {string} in the browser")
	public void openPage(String url) {
		DriverManager.getDriver().get(url);
		initializePages();
	}

	@When("the user selects {string} on the cookie message")
	public void acceptCookies(String buttonText) {
		if (cookieBannerPage == null) {
			cookieBannerPage = new CookieBannerPage();
		}
		cookieBannerPage.acceptCookies();
		cookiesAccepted = true;
	}

	@When("the user clicks on the burger menu")
	public void openBurgerMenu() {
		homePage.openBurgerMenu();
	}

	@When("the user selects the {string} option")
	public void selectMenuOption(String option) {
		homePage.selectMenuOption(option);
	}

	@Given("the user should be redirected to the settings page")
	public void givenUserOnSettingsPage() {
		String currentUrl = DriverManager.getDriver().getCurrentUrl();
		Assert.assertTrue("Expected to be on settings page but was on: " + currentUrl,
				currentUrl.contains("/settings"));
		settingsPage = new SettingsPage();
	}

	private void handleCookiesIfNeeded() {
		if (!cookiesAccepted) {
			if (cookieBannerPage == null) {
				cookieBannerPage = new CookieBannerPage();
			}
			if (cookieBannerPage.isCookieBannerDisplayed()) {
				cookieBannerPage.acceptCookies();
				cookiesAccepted = true;
			}
		}
	}

	@When("the user selects {string} from the country dropdown")
	public void selectCountry(String newCountry) {
		settingsPage.selectCountry(newCountry);
	}

	@When("the user confirms the country change")
	public void confirmCountryChange() {
		settingsPage.confirmCountryChange();
	}

	@Given("the user is on the USA home page")
	public void verifyOnUSHomePage() {
		String currentUrl = DriverManager.getDriver().getCurrentUrl().toLowerCase();
		Assert.assertTrue("Expected to be on US home page but was on: " + currentUrl,
				currentUrl.contains("westernunion.com/us/en") || currentUrl.contains("westernunion.com/us/en/home"));
		homePage = new HomePage();
		handleCookiesIfNeeded();
	}

	@Given("the user is on the Pay Bill page")
	public void verifyOnPayBillPage() {
		String currentUrl = DriverManager.getDriver().getCurrentUrl().toLowerCase();
		Assert.assertTrue("Expected to be on Pay Bill page but was on: " + currentUrl,
				currentUrl.contains("/billpay-start") || currentUrl.contains("/billpay"));
		payBillsPage = new PayBillsPage();
		handleCookiesIfNeeded();
	}

	@When("the user searches for {string} and selects it from the list")
	public void searchAndSelectBiller(String companyName) {
		payBillsPage.searchForBiller(companyName);
	}

	@When("the user enters {string} in the send amount field")
	public void enterAmount(String amount) {
		payBillsPage.enterSendAmount(amount);
	}

	@When("the user enters {string} in the account number field")
	public void enterAccountNumber(String accountNumber) {
		payBillsPage.enterAccountNumber(accountNumber);
	}

	@When("the user clicks on {string}")
	public void handleButtonClick(String buttonText) {
		if ("Continue".equals(buttonText)) {
			payBillsPage.clickContinue();
		}
	}

	@When("the user chooses the {string} option")
	public void selectPaymentOption(String option) {
		if ("Pay in Store".equals(option)) {
			payBillsPage.selectPayInStore();
		}
	}

	@When("the user selects delivery service")
	public void selectDeliveryService() {
		payBillsPage.selectDeliveryService();
	}

	@When("the user selects {string} from the state dropdown")
	public void selectState(String state) {
		payBillsPage.selectStateFromDropdown(state);
	}
}