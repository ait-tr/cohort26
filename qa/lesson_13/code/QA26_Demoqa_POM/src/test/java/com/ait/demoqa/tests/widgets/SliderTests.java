package com.ait.demoqa.tests.widgets;

import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.SidePanel;
import com.ait.demoqa.pages.widgets.SliderPage;
import com.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectSlider();
    }

    @Test
    public void sliderTest() {
        new SliderPage(driver).moveSliderInHorizontalDirection()
                .assertToMoveSlider("100");
    }

}
