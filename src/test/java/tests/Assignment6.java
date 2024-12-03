package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assignment6 extends BaseTest {
    @Test
    public void performDragAndDrop() {
        setUp();
        driver.get("http://jqueryui.com/droppable/");

        // Switch to iframe
        WebDriver iframe = driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        // Perform drag and drop
        WebElement source = iframe.findElement(By.id("draggable"));
        WebElement target = iframe.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();

        // Validate text change and CSS color
        String targetText = target.getText();
        Assert.assertEquals(targetText, "Dropped!", "Text validation failed.");

        String cssColor = target.getCssValue("background-color");
        Assert.assertTrue(cssColor.contains("rgba(0, 128, 0"), "CSS Color validation failed.");
    }
}
