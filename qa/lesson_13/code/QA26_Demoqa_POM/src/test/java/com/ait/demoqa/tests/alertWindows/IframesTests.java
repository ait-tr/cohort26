package com.ait.demoqa.tests.alertWindows;

import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.SidePanel;
import com.ait.demoqa.pages.alertWindows.IframesPage;
import com.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframesTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAlertsFrameWindows();
    }

    @Test
    public void iframesTest() {
        new SidePanel(driver).selectFrames();
        new IframesPage(driver).returnListOfIframes().switchToFrameByIndex(3);
    }

    @Test
    public void switchToIframeByIDTest() {
        new SidePanel(driver).selectFrames();
        new IframesPage(driver).switchToIframeByID();
    }

    @Test
    public void switchToNestedIframesTest() {
        new SidePanel(driver).selectNestedFrames();
        new IframesPage(driver).switchToNestedIframes();
    }
}
