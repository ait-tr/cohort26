package com.ait.demoqa.tests.widgets;

import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.SidePanel;
import com.ait.demoqa.pages.widgets.SelectMenuPage;
import com.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectSelectMenu();
    }

    @Test
    public void selectOldStyleTest() {
        new SelectMenuPage(driver).selectOldStyle("Purple");
    }

    @Test
    public void multiSelectTest() {
        new SelectMenuPage(driver).multiSelect(new String[]{"Blue","Black","Red"});
    }

    @Test
    public void multiSelectTest1() {
        new SelectMenuPage(driver).multiSelect1("Blue");
    }

    @Test
    public void standardMultiSelectTest() {
        new SelectMenuPage(driver).standardMultiSelect(2);
    }
}
