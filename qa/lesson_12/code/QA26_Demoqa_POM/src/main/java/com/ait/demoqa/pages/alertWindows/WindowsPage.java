package com.ait.demoqa.pages.alertWindows;

import com.ait.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class WindowsPage extends BasePage {

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Click Here']")
    WebElement link;

    public WindowsPage switchToNewTab(int index) {
        click(link);

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    @FindBy(tagName = "h3")
    WebElement title;

    public WindowsPage assertNewTab(String text) {
        Assert.assertTrue(shouldHaveText(title,text,5));
        return this;
    }
}
