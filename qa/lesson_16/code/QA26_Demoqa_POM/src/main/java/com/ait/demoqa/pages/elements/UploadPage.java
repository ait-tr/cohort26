package com.ait.demoqa.pages.elements;

import com.ait.demoqa.pages.BasePage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class UploadPage extends BasePage {

    public UploadPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "uploadFile")
    WebElement uploadFile;

    public UploadPage performKeyEventUsingRobot() {
        pause(1000);

        clickWithRectangle(uploadFile,2,4);
        //create object of Robot class
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        //press shift key
        robot.keyPress(KeyEvent.VK_SHIFT);
        pause(1000);
        //press d(upper case as Shift key is pressed)
        robot.keyPress(KeyEvent.VK_D);
        //release Shift key to release upper case effect
        robot.keyRelease(KeyEvent.VK_SHIFT);
        //press 1, ., t, x, t
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_PERIOD);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_X);
        robot.keyPress(KeyEvent.VK_T);
        //press ENTER to close the popup
        robot.keyPress(KeyEvent.VK_ENTER);
        return this;
    }

    @FindBy(id = "uploadedFilePath")
    WebElement uploadedFilePath;

    public UploadPage assertPath(String path) {
        Assert.assertTrue(isTextPresent(uploadedFilePath,path));
        return this;
    }

    public UploadPage performMouseEventUsingRobot() {
        pause(1000);
        clickWithRectangle(uploadFile,2,4);
        //create object of Robot class
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        //get window size
        Dimension dimension = driver.manage().window().getSize();
        System.out.println("Dimension x and y: " + dimension.getWidth() + " "
                + dimension.getHeight());
        //get point of file location
        int x = dimension.getWidth() / 4 + 550;
        int y = dimension.getHeight() / 2;
        //move mouse point with coordinates
        robot.mouseMove(x,y);
        pause(1000);
        //click left mouse button
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        //release left mouse button
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        pause(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        return this;
    }
}
