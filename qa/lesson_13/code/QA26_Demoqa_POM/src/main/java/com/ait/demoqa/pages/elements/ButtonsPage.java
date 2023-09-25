package com.ait.demoqa.pages.elements;

import com.ait.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ButtonsPage extends BasePage {

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickBtn;

    public ButtonsPage doubleClick() {
        pause(500);
        //Actions actions = new Actions(driver);
        new Actions(driver).doubleClick(doubleClickBtn).build().perform();
        return this;
    }

    @FindBy(id = "doubleClickMessage")
    WebElement doubleClickMessage;

    public ButtonsPage assertDoubleClick(String message) {
        Assert.assertTrue(isTextPresent(doubleClickMessage,message));
        return this;
    }

    @FindBy(id = "rightClickBtn")
    WebElement rightClickBtn;

    public ButtonsPage rightClick() {
        pause(500);
        new Actions(driver).contextClick(rightClickBtn).perform();
        return this;
    }

    @FindBy(id = "rightClickMessage")
    WebElement rightClickMessage;

    public ButtonsPage assertRightClick(String message) {
        Assert.assertTrue(isTextPresent(rightClickMessage,message));
        return this;
    }
}
