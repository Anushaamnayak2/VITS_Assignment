package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment1 extends BaseTest {

    @BeforeMethod
    public void setUpTest() {
        setUp(); // Initialize the browser from BaseTest
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown(); // Close the browser from BaseTest
    }

    @Test
    public void verifyNavigationAndTitle() {
        // Navigate to the VITS website
        driver.get("https://vitscc.com/");

        // Verify the title of the page
        String actualTitle = driver.getTitle();
        String expectedTitle = "VITS Consulting Corp";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        // Assert the title
        Assert.assertEquals(actualTitle, expectedTitle, "Title Verification");

        // Navigate to Facebook
        driver.navigate().to("https://www.facebook.com");

        // Navigate back to the VITS website
        driver.navigate().back();

        // Print the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        // Navigate forward
        driver.navigate().forward();

        // Reload the page
        driver.navigate().refresh();
    }
}
