package com.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewUserTests extends TestBase{

    @Test
    public void createNewUserPositiveTest() {
        //click on login link - //a[contains(.,'LOGIN')] - xpath
        driver.findElement(By.xpath("//a[contains(.,'LOGIN')]")).click();
        //enter email - [placeholder='Email'] - css
        driver.findElement(By.cssSelector("[placeholder='Email']")).click();
        driver.findElement(By.cssSelector("[placeholder='Email']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("stark@gmail.com");
        //enter password - [placeholder='Password'] - css
        driver.findElement(By.cssSelector("[placeholder='Password']")).click();
        driver.findElement(By.cssSelector("[placeholder='Password']")).clear();
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("Stark1234$");
        //click on Registration button - registration - name
        driver.findElement(By.name("registration")).click();
        //assert Sign out button present - //button[contains(.,'Sign Out')] - xpath
        Assert.assertTrue(isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));
    }
}
