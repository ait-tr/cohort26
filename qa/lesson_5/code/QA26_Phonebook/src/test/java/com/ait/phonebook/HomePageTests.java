package com.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void isHomeComponentPresentTest() {
        // System.out.println("Home Component is " + isHomeComponentPresent());
        //  System.out.println("Home Component is " + isElementPresent(By.xpath("//div[2]/div/div")));
        //  System.out.println("Home Component is " + isElementPresent(By.xpath("//div[2]/div/div")));
        Assert.assertTrue(isHomeComponentPresent());
    }

}
