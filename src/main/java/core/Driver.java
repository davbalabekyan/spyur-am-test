package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public final class Driver {

    private WebDriver driver;

    public WebDriver getDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }

//    public void initializeDriver(String browserName) {
//        if (driver == null) {
//            if (browserName.equalsIgnoreCase("chrome")) {
//                initializeChromeDriver();
//            } else if (browserName.equalsIgnoreCase("firefox")) {
//                initializeFirefoxDriver();
//            } else {
//                throw new RuntimeException("Wrong browser name");
//            }
//        }
//    }
//
//    private void initializeChromeDriver() {
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--incognito");
//        chromeOptions.addArguments("--start-maximized");
//
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver(chromeOptions);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }
//
//    private void initializeFirefoxDriver() {
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.addArguments("--incognito");
//        firefoxOptions.addArguments("--start-maximized");
//
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver(firefoxOptions);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }
//
//    public WebDriver getDriverInstance() {
//        return driver;
//    }
//
//    public void quitDriver() {
//        driver.quit();
//        driver = null;
//    }
//    public void quitDriver() {
//        if (browserName.equalsIgnoreCase("chrome")) {
//            chromeDriver.quit();
//            chromeDriver = null;
//        } else if (browserName.equalsIgnoreCase("firefox")) {
//            firefoxDriver.quit();
//            firefoxDriver = null;
//        } else {
//            throw new RuntimeException("Wrong browser name");
//        }
//        driver.quit();
//        driver = null;

//    }
//    public static WebDriver getDriverInstance(String browser) {
//        if (browser.equalsIgnoreCase("firefox")) {
//            if (firefoxDriver != null) {
//                return firefoxDriver;
//            }
//        } else {
//            if (chromeDriver != null) {
//                return chromeDriver;
//            }
//        }
//        throw new RuntimeException("There isn't driver");

//    }
}
