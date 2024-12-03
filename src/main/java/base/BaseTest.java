package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

            System.setProperty("web driver.chrome.driver", "/path/to/chromedriver");
            driver = new ChromeDriver();

            System.setProperty("web driver.gecko.driver", "/path/to/geckodriver");
            driver = new FirefoxDriver();
        // Maximize the browser window
        driver.manage().window().maximize();

        // Set implicit wait for WebDriver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
