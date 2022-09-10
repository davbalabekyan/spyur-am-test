package pages;

import helper_classes.UiHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class BaseSearchPage extends BasePage {

    private final By by = By.xpath("//a[@class='next_page']");
    @FindBy(xpath = "//h1/span")
    private WebElement searchResultName;
    @FindBy(xpath = "//a[@class='next_page']")
    protected WebElement nextButton;
    @FindBy(xpath = "//div[@class='main_logo']/a")
    private WebElement homePageButton;
    @FindBy(xpath = "//div[@class='paging']//ul/li")
    protected List<WebElement> pages;
    @FindBy(xpath = "//div[@id='results_list_wrapper']/a")
    protected List<WebElement> onePageResults;

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
