package pages;

import helper_classes.UiHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings(value = "all")
public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@name='company_name']")
    private WebElement whatToLookFor;
    @FindBy(xpath = "//input[@name='addres']")
    private WebElement location;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[1]/div[1]/div/ul/li[4]/a")
    private WebElement restaurantsPageButton;
    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[1]/div[1]/div/ul/li[7]/a")
    private WebElement furniturePageButton;
    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[1]/div[1]/div/ul/li[5]/a")
    private WebElement hotelPageButton;
    @FindBy(xpath = "//ul[@class='menu_list']/li[8]/a")
    private WebElement linksButton;

    @Override
    protected String pageUrl() {
        return "https://www.spyur.am/am/home";
    }

    public void doASearch(final String whatToLookFor, final String whereToFind) {
        this.location.sendKeys(whereToFind);
        doASearchInternal(whatToLookFor);
    }

    public void doASearchOnlyLocation(final String whereToFind) {
        doASearchOnlyLocationInternal(whereToFind);
    }

    public void doASearch(final String whatToLookFor) {
        doASearchInternal(whatToLookFor);
    }

    private void doASearchInternal(final String whatToLookFor) {
        this.whatToLookFor.sendKeys(whatToLookFor);
        UiHelper.clickOnWebElement(submitButton);
    }

    private void doASearchOnlyLocationInternal(final String whereToLookFor) {
        this.location.sendKeys(whereToLookFor);
        UiHelper.clickOnWebElement(submitButton);
    }

    public void openRestaurantsPage() {
        UiHelper.clickOnWebElement(restaurantsPageButton);
    }

    public void openFurniturePage() {
        UiHelper.clickOnWebElement(furniturePageButton);
    }

    public void openHotelsPage() {
        UiHelper.clickOnWebElement(hotelPageButton);
    }

    public void openLinksPage() {
        UiHelper.clickOnWebElement(linksButton);
    }
}
