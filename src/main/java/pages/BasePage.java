package pages;

import core.DriverProvider;
import helper_classes.UiHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

abstract class BasePage {

    @FindBy(xpath = "//ul[contains(@class,'lg_list')]")
    private WebElement languageSelect;
    @FindBy(xpath = "//ul[contains(@class,'lg_list')]/li[@class='current']/a")
    private WebElement currentLanguage;
    private final WebDriver driver;


    public BasePage() {
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }

    protected String pageUrl() {
        return "";
    }

    public void get() {
        driver.get(pageUrl());
    }

    public void changeLanguage(String lang) {
        UiHelper.clickOnWebElement(languageSelect);
        String format = String.format("./li[not(contains(@class,'current'))]/a[contains(text(),'%s')]", lang);
        WebElement element = languageSelect.findElement(By.xpath(format));
        UiHelper.clickOnWebElement(element);
    }

    public String getCurrentLanguage() {
        return currentLanguage.getText();
    }

    public String getCurrentLUrl() {
        return driver.getCurrentUrl();
    }
}
