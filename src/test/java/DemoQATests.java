import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoQATests {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "/hacer/IdeaProjects/rd_homework14/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testClickButton() {
        // Step 1: Navigate to the URL
        driver.get("https://demoqa.com/elements");

        // Step 2: Click the "Buttons" option
        WebElement buttonsOption = driver.findElement(By.cssSelector("div.card-body > h5:contains('Buttons')"));
        buttonsOption.click();

        // Step 3: Click the "Click Me" button
        WebElement clickMeButton = driver.findElement(By.cssSelector("button#btn btn-primary"));
        clickMeButton.click();

        // Step 4: Verify the message
        WebElement message = driver.findElement(By.cssSelector("div#dynamicClickMessage"));
        Assert.assertEquals(message.getText(), "You have done a dynamic click");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
