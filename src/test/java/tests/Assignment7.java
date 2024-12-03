package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment7 extends BaseTest {
    @Test
    public void sendEmailOnGmail() {
        setUp();
        driver.get("https://www.gmail.com");

        // Login
        driver.findElement(By.id("identifierId")).sendKeys("validEmail@gmail.com");
        driver.findElement(By.id("identifierNext")).click();
        driver.findElement(By.name("password")).sendKeys("validPassword");
        driver.findElement(By.id("passwordNext")).click();

        // Verify login
        Assert.assertTrue(driver.getTitle().contains("Inbox"), "Login verification failed.");

        // Compose email
        driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).click();
        driver.findElement(By.name("to")).sendKeys("qatesting@vitsconsulting.com");
        driver.findElement(By.name("subject")).sendKeys("QA Automation Test Mail");
        driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("This is a test email.");
        driver.findElement(By.xpath("//div[contains(text(),'Send')]")).click();

        // Validate email sent (add appropriate validation)
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Message sent')]")).isDisplayed());
    }
}
