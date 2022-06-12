package coreTest;

import core.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver webDriver;

    @Parameters("browserName")
    @BeforeTest
    public void setup(String browserName) {
        Driver driver = new Driver();
        webDriver = driver.getDriver(browserName);
    }

    @AfterSuite
    public void tearDown() {
        webDriver.quit();
    }
}
