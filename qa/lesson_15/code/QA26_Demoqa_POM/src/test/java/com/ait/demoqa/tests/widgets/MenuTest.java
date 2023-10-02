package com.ait.demoqa.tests.widgets;

import com.ait.demoqa.pages.HomePage;
import com.ait.demoqa.pages.SidePanel;
import com.ait.demoqa.pages.widgets.MenuPage;
import com.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getWidgets();
        new SidePanel(driver).getMenu().hideIframes();
    }

    @Test
    public void menuTest() {
        new MenuPage(driver).openSubMenu()
                .assertSubItem();
    }
}
