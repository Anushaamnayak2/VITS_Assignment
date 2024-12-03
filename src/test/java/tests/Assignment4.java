package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Assignment4 extends BaseTest {
    @Test
    public void searchProductOnEbay() {
        setUp();
        driver.get("https://www.ebay.com");

        // Search for a product
        driver.findElement(By.id("gh-ac")).sendKeys("Apple Watches");

        // Select category
        Select categoryDropdown = new Select(driver.findElement(By.id("gh-cat")));
        categoryDropdown.selectByVisibleText("Electronics");

        // Click search
        driver.findElement(By.id("gh-btn")).click();

        // Verify results
        String resultsText = driver.findElement(By.className("srp-controls__count-heading")).getText();
        System.out.println("Search Results: " + resultsText);
    }
}
