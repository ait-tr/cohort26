package com.ilcarro.stepDefinitions;

import com.ilcarro.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.ilcarro.pages.BasePage.driver;

public class HomePageSteps {

    @Given("User launches Chrome Browser")
    public void launchChromeBrowser() {
        new HomePage(driver).launchBrowser();
    }

    @When("User opens ilcarro HomePage")
    public void openIlcarroHomePage() {
        new HomePage(driver).openUrl();
    }

    @Then("User verifies HomePage title")
    public void verifyHomePageTitle () {
        new HomePage(driver).isHomePageTitlePresent();
    }

    @And("User quites browser")
    public void quitBrowser() {
        new HomePage(driver).quit();
    }
}
