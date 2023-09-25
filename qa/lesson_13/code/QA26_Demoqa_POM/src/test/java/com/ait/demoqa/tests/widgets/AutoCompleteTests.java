package com.ait.demoqa.tests.widgets;

import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.SidePanel;
import com.ait.demoqa.pages.widgets.AutoCompletePage;
import com.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoCompleteTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectAutoComplete();
    }

    @Test
    public void autoCompleteTest() {
        new AutoCompletePage(driver).autoComplete()
                .assertColor("Magenta");
    }
}
