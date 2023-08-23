import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElementsTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");

        //maximize browser window
        driver.manage().window().maximize();
        //set implicit timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void findElementsTest() {
        //find element by tag name
        WebElement element = driver.findElement(By.tagName("app-search"));
        System.out.println(element.getText());
        //find list of elements
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());

        //find element by id
        driver.findElement(By.id("city")); // <input id="city"></input>

        //find element by name
        driver.findElement(By.name("viewport"));// <div name="name"></div>

        //find element by link text
        driver.findElement(By.linkText("Search"));

        //find element by partial link text
        driver.findElement(By.partialLinkText("work"));

        //find element by class name
        driver.findElement(By.className("input-label"));
    }

    @Test
    public void findElementByCssTest() {
        //tag name = css
        // driver.findElement(By.tagName("app-search"));
        driver.findElement(By.cssSelector("app-search"));

        //id -> css(#)
        // driver.findElement(By.id("city"));
        driver.findElement(By.cssSelector("#city"));

        //class name -> css(.)
        //driver.findElement(By.className("input-label"));
        driver.findElement(By.cssSelector(".input-label"));

        //attribute-parameter -> css([])
        //driver.findElement(By.name("viewport"));
        driver.findElement(By.cssSelector("[name='viewport']"));

        //contains -> *
        driver.findElement(By.cssSelector("[class*='line']"));
        //start -> ^
        driver.findElement(By.cssSelector("[class^='red']"));
        //end on -> $
        driver.findElement(By.cssSelector("[class$='triangle']"));
    }

    @Test
    public void findElementByXpathTest() {
        //tag name = xpath //tag
        // driver.findElement(By.tagName("app-search"));
        driver.findElement(By.xpath("//app-search"));

        //id, class and so on -> xpath //*[@attr='value']
        // driver.findElement(By.id("city"));
        driver.findElement(By.xpath("//input[@id='city']"));

        //contains -> //*[contains(.,'Text')]
        driver.findElement(By.xpath("//h1[contains(.,'Find your car now!')]"));
    }

    @AfterMethod
    public void tearDawn() {
        driver.quit();
    }
}
