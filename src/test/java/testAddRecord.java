import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



@Test
public void testAddRecord() {
    WebDriver driver;

    // Step 1: Navigate to the URL
    driver.get("https://demoqa.com/webtables");

    // Step 2: Click the "ADD" button
    WebElement addButton = driver.findElement(By.cssSelector("button#addNewRecordButton"));
    addButton.click();

    // Fill in the form
    driver.findElement(By.cssSelector("input#firstName")).sendKeys("HACER");
    driver.findElement(By.cssSelector("input#lastName")).sendKeys("BAY");
    driver.findElement(By.cssSelector("input#userEmail")).sendKeys("hacerbayram95@gmail.com");
    driver.findElement(By.cssSelector("input#age")).sendKeys("29");
    driver.findElement(By.cssSelector("input#salary")).sendKeys("200000");
    driver.findElement(By.cssSelector("input#department")).sendKeys("software Test Engineer");

    // Submit the form
    WebElement submitButton = driver.findElement(By.cssSelector("button#submit"));
    submitButton.click();

    // Step 3: Edit the added record
    WebElement editButton = driver.findElement(By.cssSelector("span[title='Edit']"));
    editButton.click();

    // Update the information
    WebElement salaryField = driver.findElement(By.cssSelector("input#salary"));
    salaryField.clear();
    salaryField.sendKeys("120000");

    // Save the changes
    submitButton.click();

    // Step 4: Verify the changes
    WebElement salaryCell = driver.findElement(By.cssSelector("div.rt-td:nth-child(5)"));
    Assert.assertEquals(salaryCell.getText(), "120000");
}
