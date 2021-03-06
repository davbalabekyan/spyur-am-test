package pages;

import core.Driver;
import helper_classes.UiHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings(value = "all")
abstract class BasePage {

    private WebDriver webDriver;
    @FindBy(xpath = "//ul[contains(@class,'lg_list')]")
    private WebElement languageSelect;
    @FindBy(xpath = "//ul[contains(@class,'lg_list')]/li[@class='current']/a")
    private WebElement currentLanguage;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    protected String pageUrl() {
        return "";
    }

    public void get() {
        webDriver.get(pageUrl());
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
        return webDriver.getCurrentUrl();
    }
}
