package com.ait.demoqa.tests.alertWindows;

import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.alertWindows.AlertsPage;
import com.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAlerts();
    }

    @Test
    public void acceptAlertTest() {
        new AlertsPage(driver).acceptAlert()
                .assertAcceptAlert("You successfully clicked an alert");
    }

    @Test
    public void confirmAlertTest() {
        new AlertsPage(driver).confirmAlert("cancel")
                .assertAcceptAlert("Cancel");
    }

    @Test
    public void sendTextToAlertTest() {
        new AlertsPage(driver).sendTextToAlert("Hello world!!!")
                .assertAcceptAlert("Hello world!!!");
    }

}
