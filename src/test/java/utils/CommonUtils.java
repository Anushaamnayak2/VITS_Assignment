package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonUtils {

    public WebDriver getBrowserDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                System.setProperty("web driver.chrome.driver", "/path/to/chromedriver");
                return new ChromeDriver();
            case "firefox":
                System.setProperty("web driver.gecko.driver", "/path/to/geckodriver");
                return new FirefoxDriver();
            // Add more browsers if needed.
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
    }
}
