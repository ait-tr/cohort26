package com.ait.demoqa.tests.elements;

import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.SidePanel;
import com.ait.demoqa.pages.elements.UploadPage;
import com.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadRobotTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getElements();
        new SidePanel(driver).getUpload().hideIframes();
    }

    @Test
    public void robotKeyEventTest() {
        new UploadPage(driver).performKeyEventUsingRobot()
                .assertPath("C:\\fakepath\\D1.txt.odt");
    }

    @Test
    public void robotMouseEventTest() {
        new UploadPage(driver).performMouseEventUsingRobot()
                .assertPath("C:\\fakepath\\D1.txt.odt");
    }
}
