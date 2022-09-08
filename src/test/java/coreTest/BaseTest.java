package coreTest;

import core.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

    @BeforeTest
    public void setup() {
        DriverProvider.getDriver();
    }

    @AfterSuite
    public void tearDown() {
        DriverProvider.quitDriver();
    }
}
