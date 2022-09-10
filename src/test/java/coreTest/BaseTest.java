package coreTest;

import core.DriverProvider;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

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
