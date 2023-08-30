package com.ait.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddNewContactTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
        clickOnLoginLink();
        fillLoginRegisterForm();
        click(By.xpath("//button[text()='Login']"));
        //click on ADD link - a:nth-child(5) - css
        click(By.cssSelector("a:nth-child(5)"));
    }

    @Test
    public void addNewContactPositiveTest() {
        //fill in all input fields - input:nth-child(1) - css
        type(By.cssSelector("input:nth-child(1)"),"Karl");
        type(By.cssSelector("input:nth-child(2)"),"Adam");
        type(By.cssSelector("input:nth-child(3)"),"1234567890");
        type(By.cssSelector("input:nth-child(4)"),"adam@gm.com");
        type(By.cssSelector("input:nth-child(5)"),"Koblenz");
        type(By.cssSelector("input:nth-child(6)"),"goalkeeper");
        //click on Save button - .add_form__2rsm2 button - css
        click(By.cssSelector(".add_form__2rsm2 button"));
        //assert new contact added - h2
        Assert.assertTrue(isContactAdded("Karl"));
    }

    @AfterMethod
    public void postCondition() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
    }

    public boolean isContactAdded(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement el: contacts) {
            if (el.getText().contains(text))
                return true;
        }
        return false;
    }
}
