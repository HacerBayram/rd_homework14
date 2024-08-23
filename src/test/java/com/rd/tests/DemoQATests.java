package com.rd.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DemoQATests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Set up the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "src/main/java/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        //options.addArguments("--headless");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--incognito");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);

        //PageLoadTimeout
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        //ImplicitWait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void testClickButton() {
        // Step 1: Navigate to the URL
        driver.get("https://demoqa.com/elements");

        List<WebElement> elementList = driver.findElements(By.cssSelector("ul.menu-list > li.btn#item-4"));

        if (!elementList.isEmpty()) {
            elementList.get(0).click();  // Clicks the first element in the list
        }

        List<WebElement> elementList2 = driver.findElements(By.cssSelector("div > .btn"));

        if (!elementList2.isEmpty()) {
            elementList2.get(2).click();
        }

        WebElement message = driver.findElement(By.id("dynamicClickMessage"));
        Assert.assertEquals(message.getText(), "You have done a dynamic click");
    }
    @Test
    public void testWebTables() {
        // Step 1: Navigate to the URL
        driver.get("https://demoqa.com/webtables");

        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        new Actions(driver).click(addButton).perform();

        WebElement firstNamePlaceHolder = driver.findElement(By.cssSelector("input[placeholder=\"First Name\"]"));
        firstNamePlaceHolder.sendKeys("Hacer");

        WebElement lastNamePlaceHolder = driver.findElement(By.cssSelector("input[placeholder=\"Last Name\"]"));
        lastNamePlaceHolder.sendKeys("Bayram");

        WebElement emailPlaceHolder = driver.findElement(By.cssSelector("input[placeholder=\"name@example.com\"]"));
        emailPlaceHolder.sendKeys("hacerbayram95@gmail.com");

        WebElement agePlaceHolder = driver.findElement(By.cssSelector("input[placeholder=\"Age\"]"));
        agePlaceHolder.sendKeys("29");

        WebElement salaryPlaceHolder = driver.findElement(By.cssSelector("input[placeholder=\"Salary\"]"));
        salaryPlaceHolder.sendKeys("60");

        WebElement departmentPlaceHolder = driver.findElement(By.cssSelector("input[placeholder=\"Department\"]"));
        departmentPlaceHolder.sendKeys("Test Management and Automation Services");


        WebElement submitButton = driver.findElement(By.id("submit"));
        new Actions(driver).click(submitButton).perform();


        List<WebElement> editRecordElementList = driver.findElements(By.cssSelector("div.action-buttons > span[class='mr-2']"));

        if (!editRecordElementList.isEmpty()) {
            editRecordElementList.get(editRecordElementList.size() - 1).click(); // clicks the last element in the list
        }


        // String newName = "Melisa";
        //firstNamePlaceHolder.sendKeys(newName);

       // String currentValue = firstNamePlaceHolder.getAttribute("value");
       // Assert.assertEquals(currentValue, newName, "The name in the input field should be the new name.");



    }

    @AfterClass
    public void tearDown() {
        // Close the browser
      // driver.quit();
    }
}
