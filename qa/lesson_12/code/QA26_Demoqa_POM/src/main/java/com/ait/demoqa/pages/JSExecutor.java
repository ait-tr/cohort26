package com.ait.demoqa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JSExecutor extends BasePage{
    JavascriptExecutor js;

    public JSExecutor(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    public JSExecutor enterDataWithJSExecutor(String user, String password) {
        if (user != null && password != null) {
            js.executeScript("document.getElementById('username').value='" + user + "';");
            js.executeScript("document.getElementById('password').value='" + password + "';");
        }
        return this;
    }

    public JSExecutor clickWithJS() {
        js.executeScript("document.querySelector('.fa-sign-in').click();");
        return this;
    }

    public JSExecutor checkURLwithJS() {
        String url = js.executeScript("return document.URL;").toString();
        System.out.println("URL of the site: " + url);
        return this;
    }

    public JSExecutor checkTitleOfPageWithJS() {
        System.out.println("*******************************************");

        String title = js.executeScript("return document.title;").toString();
        System.out.println("Title of the page: " + title);
        return this;
    }
}
