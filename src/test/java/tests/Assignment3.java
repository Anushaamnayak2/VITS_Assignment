package tests;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

    public class Assignment3 extends BaseTest {
        @Test
        public void verifyFlipkartLinks() {
            setUp();
            driver.get("https://flipkart.com");

            // Close login popup if present
            try {
                driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();
            } catch (Exception e) {
                System.out.println("Login popup not displayed.");
            }

            // Get all links
            List<WebElement> links = driver.findElements(By.tagName("a"));
            System.out.println("Number of links on the homepage: " + links.size());

            // Print link text and URLs
            for (WebElement link : links) {
                String linkText = link.getText();
                String linkURL = link.getAttribute("href");
                System.out.println("Link Text: " + linkText + " | URL: " + linkURL);
            }
        }
    }
