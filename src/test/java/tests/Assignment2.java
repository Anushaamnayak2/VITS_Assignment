package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Assignment2 extends BaseTest {
    @Test
    public void verifyFacebookRedirection() {
        setUp();
        driver.get("http://www.fb.com");

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.facebook.com";

        assertEquals(actualURL, expectedURL, "URL Redirection Verification");

        Assert.assertTrue(driver.getPageSource().contains("Create an account"), "Create Account Section Verification");
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Doe");
        driver.findElement(By.name("reg_email__")).sendKeys("johndoe@example.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("johndoe@example.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("password123");
        new Select(driver.findElement(By.id("day"))).selectByVisibleText("15");
        new Select(driver.findElement(By.id("month"))).selectByVisibleText("Dec");
        new Select(driver.findElement(By.id("year"))).selectByVisibleText("1990");
        driver.findElement(By.xpath("//label[text()='Male']")).click();
        driver.findElement(By.name("web submit")).click();

        // Add code to validate successful account creation if applicable.
    }
}