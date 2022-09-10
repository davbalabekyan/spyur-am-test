package pages;

import helper_classes.UiHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@name='company_name']")
    private WebElement whatToLookFor;
    @FindBy(xpath = "//input[@name='addres']")
    private WebElement searchLocationInput;
    @FindBy(css = ".search_form button")
    private WebElement submitButton;
    @FindBy(xpath = "//*[@class='row']/ul/li[4]")
    private WebElement restaurantsPageButton;
    @FindBy(xpath = "//*[@class='row']/ul/li[7]")
    private WebElement furniturePageButton;
    @FindBy(xpath = "//*[@class='row']/ul/li[5]")
    private WebElement hotelPageButton;
    @FindBy(xpath = "//ul[@class='menu_list']/li[last()]/a")
    private WebElement linksPageButton;

    @Override
    protected String pageUrl() {
        return "https://www.spyur.am/am/home";
    }

    public void doASearch(final String whatToLookFor, final String whereToFind) {
        UiHelper.sendKeys(this.searchLocationInput, whereToFind);
        doASearchInternal(whatToLookFor);
    }

    public void doASearchOnlyLocation(final String whereToFind) {
        doASearchOnlyLocationInternal(whereToFind);
    }

    public void doASearch(final String whatToLookFor) {
        doASearchInternal(whatToLookFor);
    }

    private void doASearchInternal(final String whatToLookFor) {
        UiHelper.sendKeys(this.whatToLookFor, whatToLookFor);
        UiHelper.clickOnWebElement(submitButton);
    }

    private void doASearchOnlyLocationInternal(final String whereToLookFor) {
        UiHelper.sendKeys(this.searchLocationInput, whereToLookFor);
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
        UiHelper.clickOnWebElement(linksPageButton);
    }
}
