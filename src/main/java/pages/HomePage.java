package pages;

import core.UiHelper;
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
}
