package com.ait.demoqa.pages.links;

import com.ait.demoqa.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenImages extends BasePage {

    public BrokenImages(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "img")
    List<WebElement> images;

    public BrokenImages checkBrokenImages() {
        System.out.println("We have " + images.size() + " images");

        for (int index = 0; index < images.size(); index++) {
            WebElement image = images.get(index);
            String imageURL = image.getAttribute("src");
            System.out.println("URL of image " + (index + 1) + " is: " + imageURL);
            verifyLinks(imageURL);
            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return (typeof arguments[0].naturalWidth!=undefined && arguments[0]" +
                                ".naturalWidth>0);", image);
                if (imageDisplayed) {
                    System.out.println("DISPLAYED - OK");
                    System.out.println("**************************************");
                } else {
                    System.out.println("DISPLAY - BROKEN");
                    System.out.println("*************************************");
                }
            } catch (Exception e) {
                System.out.println("ERROR");
            }
        }
        return this;
    }

    public void verifyLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            if (connection.getResponseCode() >= 400) {
                System.out.println(linkUrl + " - " + connection.getResponseMessage()
                        + " is a broken link");
            } else {
                System.out.println(linkUrl + " - " + connection.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(linkUrl + " - " + e.getMessage()
                    + " is a broken link");
        }
    }
}
