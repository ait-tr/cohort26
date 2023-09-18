package com.ait.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".card.mt-4.top-card:nth-child(6)")
    WebElement bookStore;


    public SidePanel getBookStore() {
        clickWithJSExecutor(bookStore,0,300);
        return new SidePanel(driver);
    }
}
