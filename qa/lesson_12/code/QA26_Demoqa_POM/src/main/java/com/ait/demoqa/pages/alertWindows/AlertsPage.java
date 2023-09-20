package com.ait.demoqa.pages.alertWindows;

import com.ait.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[onclick='jsAlert()']")
    WebElement jsAlert;

    public AlertsPage acceptAlert() {
        click(jsAlert);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        return this;
    }

    @FindBy(id = "result")
    WebElement result;

    public AlertsPage assertAcceptAlert(String message) {
        Assert.assertTrue(isTextPresent(result, message));
        return this;
    }

    @FindBy(css = "[onclick='jsConfirm()']")
    WebElement confirm;

    public AlertsPage confirmAlert(String text) {
        click(confirm);

        if (text != null && text.equalsIgnoreCase("ok")) {
            driver.switchTo().alert().accept();
        } else if (text != null && text.equalsIgnoreCase("cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(css = "[onclick='jsPrompt()']")
    WebElement prompt;

    public AlertsPage sendTextToAlert(String text) {
        click(prompt);

        if (text != null) {
            driver.switchTo().alert().sendKeys(text);
            driver.switchTo().alert().accept();
        }
        return this;
    }
}
