package com.wu.automation.stepdefinitions;

import com.wu.automation.pages.*;
import io.cucumber.java.en.*;
import com.wu.automation.utilities.DriverManager;

public class LocationStep {
	private static volatile HomePage homePage;
    private static volatile FindLocationsPage findLocationsPage;
    private static volatile CookieBannerPage cookieBannerPage;
    
    private static HomePage getHomePage() {
        if (homePage == null) {
            synchronized (LocationStep.class) {
                if (homePage == null) {
                    homePage = new HomePage();
                }
            }
        }
        return homePage;
    }

	@Given("the user opens location page {string}")
	public void openLocationPage(String url) {
		DriverManager.getDriver().get(url);
		homePage = new HomePage();
		cookieBannerPage = new CookieBannerPage();
		try {
			cookieBannerPage.acceptCookies();
		} catch (Exception e) {
			System.out.println("No cookie banner found - proceeding");
		}
	}

	@When("the user clicks on location burger menu")
	public void openLocationBurgerMenu() {
		homePage.openBurgerMenu();
	}

	@When("the user choose the {string} option")
	public void chooseMenuOption(String option) {
		if ("Find Locations".equalsIgnoreCase(option)) {
			homePage.clickFindLocations();

		} else {
			throw new IllegalArgumentException("Invalid menu option: " + option);
		}
	}

	@Given("the user is on Find Locations page")
	public void verifyOnFindLocationsPage() {
		// Only initialize if not already done
		if (findLocationsPage == null) {
			findLocationsPage = new FindLocationsPage();
		}

		// Check if we're already on the right page
		String currentUrl = DriverManager.getDriver().getCurrentUrl();
		if (!currentUrl.contains("/global-services/find-locations")) {
			// Only navigate if we're not already there
			DriverManager.getDriver()
					.get("https://www.westernunion.com/global-services/find-locations?WUCountry=lt&WULanguage=en");
		}

		// Use the faster page load check we discussed earlier
		if (!findLocationsPage.isPageLoaded()) {
			throw new RuntimeException("Find Locations page did not load properly");
		}
	}

	@When("the user clears the location search field")
	public void clearLocationSearchField() {
		findLocationsPage.clearLocationSearchField();
	}

	@When("the user enters {string} in the location search field")
	public void enterLocationSearch(String zipCode) {
		findLocationsPage.enterLocationSearch(zipCode);
	}

	@When("the user clicks on the search button")
	public void clickSearchButton() {
		findLocationsPage.clickSearchButton();
	}

	@When("the user choose on the open button")
	public void clickOpenButton() throws InterruptedException {
		Thread.sleep(2000); // 2 second wait
		findLocationsPage.clickOpenButton();
	}

	@Then("the address of the first location should be printed in console")
	public void printFirstLocationAddress() throws InterruptedException {
		Thread.sleep(2000); // 2 second wait
		String address = findLocationsPage.getFirstLocationAddress();
		System.out.println("First location address: " + address);
	}
}