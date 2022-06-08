package coreTest;

import core.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

    @Parameters("browserName")
    @BeforeTest
    public void setup(String browserName) {
        Driver.initializeDriver(browserName);
    }

    @Parameters("browserName")
    @AfterTest
    public void tearDown(String browserName) {
        Driver.quitDriver(browserName);
    }
}
