package automation.framework.driver.impl;

import automation.framework.propertyhelpers.PropertyResolver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static WebDriver getDriver() {
        switch (PropertyResolver.testConfig.getBrowser()) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                return new ChromeDriver();
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Invalid browser name:");
        }
    }
}
