package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment5 extends BaseTest {
    @Test
    public void validateLoginWithCapturedCredentials() {
        setUp();

        // Navigate to VITS site
        driver.get("http://www.vitscc.com");
        driver.findElement(By.linkText("Employees")).click();
        driver.findElement(By.linkText("Change of address")).click();

        // Capture the last two words
        String pageText = driver.findElement(By.tagName("body")).getText();
        String[] words = pageText.split(" ");
        String username = words[words.length - 2];
        String password = words[words.length - 1];

        // Navigate to Expand Testing
        driver.get("https://practice.expandtesting.com/login");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();

        // Validate invalid login
        String response = driver.findElement(By.id("response")).getText();
        Assert.assertEquals(response, "Your username is invalid!");

        // Update with correct credentials
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("username")).sendKeys("correctUsername");
        driver.findElement(By.id("password")).sendKeys("correctPassword");
        driver.findElement(By.id("loginButton")).click();

        // Validate successful login
        Assert.assertTrue(driver.findElement(By.id("welcomeMessage")).isDisplayed());
    }
}
