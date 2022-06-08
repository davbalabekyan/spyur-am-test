package core;

import lombok.EqualsAndHashCode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

@EqualsAndHashCode
public final class Driver {

    private static WebDriver chromeDriver;
    private static WebDriver firefoxDriver;

    private Driver() {
    }

    public static void initializeDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            if (chromeDriver == null) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                options.addArguments("--start-maximized");

                chromeDriver = new ChromeDriver(options);
                chromeDriver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
            }
        } else if (browserName.equalsIgnoreCase("firefox")) {
            if (firefoxDriver == null) {
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Art\\Desktop\\geckodriver-v0.31.0-win64\\geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--incognito");
                firefoxOptions.addArguments("--start-maximized");

                firefoxDriver = new FirefoxDriver(firefoxOptions);
                firefoxDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        } else {
            throw new RuntimeException("Wrong browser name");
        }
    }

    public static void quitDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            chromeDriver.quit();
            chromeDriver = null;
        } else if (browserName.equalsIgnoreCase("firefox")) {
            firefoxDriver.quit();
            firefoxDriver = null;
        } else {
            throw new RuntimeException("Wrong browser name");
        }
    }

    public static WebDriver getDriverInstance() {
        if (firefoxDriver != null) {
            return firefoxDriver;
        } else if (chromeDriver != null) {
            return chromeDriver;
        }
        throw new RuntimeException("There isn't driver");
    }
}
