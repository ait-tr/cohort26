package com.ait.demoqa.pages.alertWindows;

import com.ait.demoqa.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IframesPage extends BasePage {

    public IframesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> iframes;

    public IframesPage returnListOfIframes() {
        //print number of iframes using tag name
        System.out.println("The total numbers of iframes on the page: " + iframes.size());

        //by executing java script
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer numberIframes = Integer.parseInt(js.executeScript("return window.length;").toString());
        System.out.println("The total numbers of iframes on the page: " + numberIframes);
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public IframesPage switchToFrameByIndex(int index) {
        driver.switchTo().frame(index);
        System.out.println("Text of the iframe: " + sampleHeading.getText());
        return this;
    }

    @FindBy(id = "frame1")
    WebElement frame1;

    @FindBy(id = "framesWrapper")
    WebElement framesWrapper;

    public IframesPage switchToIframeByID() {
        driver.switchTo().frame(frame1);
        System.out.println("Text of this iframe: " + sampleHeading.getText());
        driver.switchTo().defaultContent();
        System.out.println("Text on the main page: " + framesWrapper.getText());
        return this;
    }

    @FindBy(tagName = "body")
    WebElement body;

    public IframesPage switchToNestedIframes() {
        System.out.println("The total numbers of iframes on the page: " + iframes.size());

        driver.switchTo().frame(frame1);
        System.out.println("Frame 1 is " + body.getText());
        System.out.println("The total numbers of iframes in the parent iframe: " + iframes.size());

        driver.switchTo().frame(0);
        System.out.println("Frame 2 is " + body.getText());
        System.out.println("The total numbers of iframes in the child iframe: " + iframes.size());

//        driver.switchTo().parentFrame();
//        System.out.println("Frame 1 is " + body.getText());

        driver.switchTo().defaultContent();
        System.out.println("Text on the main page: " + framesWrapper.getText());
        return this;
    }
}
