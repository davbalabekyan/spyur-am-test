package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public final class DriverProvider {

    private static volatile WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            synchronized (DriverProvider.class) {
                if (driver == null) {
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("-private");
                    options.addArguments("--start-maximized");

                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }
}
