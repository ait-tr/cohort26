package com.ait.demoqa.pages.widgets;

import com.ait.demoqa.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectMenuPage extends BasePage {

    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;

    public SelectMenuPage selectOldStyle(String color) {
        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(color);

        List<WebElement> options = select.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }
        System.out.println("*********************************");
        System.out.println(select.getFirstSelectedOption().getText() + " is first");
        return this;
    }

    @FindBy(id = "react-select-4-input")
    WebElement selectInput;

    @FindBy(css = "html")
    WebElement space;
    public SelectMenuPage multiSelect(String[] colors) {
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] != null) {
                selectInput.sendKeys(colors[i]);
                selectInput.sendKeys(Keys.ENTER);
            }
            click(space);
        }
        return this;
    }

    @FindBy(xpath = "(//div[@class=' css-1wy0on6'])[3]")
    WebElement multiSelectDropDown;

    public SelectMenuPage multiSelect1(String text) {
        clickWithJSExecutor(multiSelectDropDown,0,200);
        WebElement element = driver.findElement(By.xpath(String.format("//div[text()='%s']",text)));
        element.click();
        click(space);
        return this;
    }

    @FindBy(id = "cars")
    WebElement cars;

    public SelectMenuPage standardMultiSelect(int index) {
        Select select = new Select(cars);
        if (select.isMultiple()) {
            select.selectByIndex(index);
        }
        return this;
    }
}
