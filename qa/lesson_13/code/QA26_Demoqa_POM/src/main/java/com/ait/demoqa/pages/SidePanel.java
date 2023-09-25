package com.ait.demoqa.pages;

import com.ait.demoqa.pages.alertWindows.IframesPage;
import com.ait.demoqa.pages.bookStore.LoginPage;
import com.ait.demoqa.pages.bookStore.ProfilePage;
import com.ait.demoqa.pages.elements.ButtonsPage;
import com.ait.demoqa.pages.widgets.AutoCompletePage;
import com.ait.demoqa.pages.widgets.SliderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanel extends BasePage {

    public SidePanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".show #item-0")
    WebElement login;

    public LoginPage selectLogin() {
        clickWithJSExecutor(login, 0, 600);
        return new LoginPage(driver);
    }

    @FindBy(css = ".show #item-3")
    WebElement profile;

    public ProfilePage selectProfile() {
        clickWithJSExecutor(profile, 0, 100);
        return new ProfilePage(driver);
    }

    @FindBy(xpath = "//span[.='Frames']")
    WebElement frames;

    public IframesPage selectFrames() {
        clickWithJSExecutor(frames, 0, 400);
        return new IframesPage(driver);
    }

    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement nestedFrames;

    public IframesPage selectNestedFrames() {
        clickWithJSExecutor(nestedFrames, 0, 400);
        return new IframesPage(driver);
    }

    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttons;

    public ButtonsPage selectButtons() {
        clickWithJSExecutor(buttons,0,300);
        return new ButtonsPage(driver);
    }

    @FindBy(xpath = "//span[.='Auto Complete']")
    WebElement autoComplete;

    public AutoCompletePage selectAutoComplete() {
        clickWithJSExecutor(autoComplete,0,300);
        return new AutoCompletePage(driver);
    }

    @FindBy(xpath = "//span[.='Slider']")
    WebElement slider;

    public SliderPage selectSlider() {
        clickWithJSExecutor(slider,0,500);
        return new SliderPage(driver);
    }
}
