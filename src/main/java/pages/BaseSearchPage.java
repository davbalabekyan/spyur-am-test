package pages;

import helper_classes.UiHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings(value = "all")
public abstract class BaseSearchPage extends BasePage {

    private final By by = By.xpath("//a[@class='next_page']");
    @FindBy(xpath = "//h1/span")
    private WebElement searchResultName;
    @FindBy(xpath = "//div[@class='main_logo']/a")
    private WebElement homePageButton;

    public String getSearchName() {
        return this.searchResultName.getText();
    }

    public final By getBy() {
        return by;
    }

    public void goToMainPage() {
        UiHelper.clickOnWebElement(homePageButton);
    }
}
