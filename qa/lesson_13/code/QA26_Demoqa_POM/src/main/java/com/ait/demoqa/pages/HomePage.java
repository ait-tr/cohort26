package com.ait.demoqa.pages;

import com.ait.demoqa.pages.alertWindows.AlertsPage;
import com.ait.demoqa.pages.alertWindows.WindowsPage;
import com.ait.demoqa.pages.links.BrokenImages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

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

    @FindBy(xpath = "//a[.='JavaScript Alerts']")
    WebElement alerts;

    public AlertsPage getAlerts() {
        click(alerts);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//a[.='Multiple Windows']")
    WebElement windows;

    public WindowsPage getMultipleWindows() {
        click(windows);
        return new WindowsPage(driver);
    }

    @FindBy(xpath = "//a[.='Form Authentication']")
    WebElement form;

    public JSExecutor getFormAuthentication() {
        click(form);
        return new JSExecutor(driver);
    }

    @FindBy(tagName = "a")
    List<WebElement> allLinks;

    public HomePage checkAllLinks() {

        String url;
        System.out.println("Total links on the page: " + allLinks.size());

        Iterator<WebElement> iterator = allLinks.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
        }
        return this;
    }

    @FindBy(xpath = "//a[.='Broken Images']")
    WebElement brokenImages;

    public BrokenImages getBrokenImages() {
        click(brokenImages);
        return new BrokenImages(driver);
    }

    @FindBy(xpath = "//h5[.='Alerts, Frame & Windows']")
    WebElement alertsFrameWindows;

    public SidePanel getAlertsFrameWindows() {
        clickWithJSExecutor(alertsFrameWindows, 0, 300);
        return new SidePanel(driver);
    }

    @FindBy(xpath = "//h5[.='Elements']")
    WebElement elements;

    public SidePanel getElements() {
        clickWithJSExecutor(elements,0,300);
        return new SidePanel(driver);
    }

    @FindBy(xpath = "//h5[.='Widgets']")
    WebElement widgets;

    public SidePanel getWidgets() {
        clickWithJSExecutor(widgets,0,300);
        return new SidePanel(driver);
    }
}
