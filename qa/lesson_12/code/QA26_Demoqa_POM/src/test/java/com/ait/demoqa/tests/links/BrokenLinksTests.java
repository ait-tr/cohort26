package com.ait.demoqa.tests.links;

import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.links.BrokenImages;
import com.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).checkAllLinks()
                .getBrokenImages();
    }

    @Test
    public void checkBrokenImagesTest() {

        new BrokenImages(driver).checkBrokenImages();
    }
}
