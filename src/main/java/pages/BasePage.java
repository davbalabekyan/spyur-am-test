package pages;

import core.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract class BasePage {

    private final WebDriver driver;

    public BasePage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    protected String pageUrl() {
        return "";
    }

    public void get() {
        driver.get(pageUrl());
    }
}
