package pages;

import helper_classes.UiHelper;
import jdbc.manager.FurnitureManager;
import jdbc.model.Furniture;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@SuppressWarnings(value = "all")
public class FurniturePage extends BaseSearchPage {

    private int allResultsNumber;
    @FindBy(xpath = "//div[@id='results_list_wrapper']/a")
    private List<WebElement> onePageResults;
    @FindBy(xpath = "//a[@class='next_page']")
    private WebElement nextButton;
    private FurnitureManager furnitureManager;
    @FindBy(xpath = "//div[@class='paging']//ul/li")
    private List<WebElement> pages;

    public FurniturePage(WebDriver webDriver) {
        super(webDriver);
    }

    private void createFurniture() {
        furnitureManager = new FurnitureManager();
        for (WebElement onePageResult : onePageResults) {
            Furniture furniture = new Furniture();
            furniture.setName(onePageResult.findElement(By.xpath(".//span/span[1]")).getText());
            furniture.setHref(onePageResult.getAttribute("href"));
            furnitureManager.create(furniture);
        }
    }

    private void createFurnitureAndSwitchToNextPage() {
        while (UiHelper.isElementPresentBy(getBy())) {
            allResultsNumber += getNumberOfOnePageResult();
            createFurniture();
            UiHelper.clickOnWebElement(nextButton);
        }
        allResultsNumber += getNumberOfOnePageResult();
        createFurniture();
    }

    public void addResultsToDB() {
        if (this.pages.size() > 1) {
            createFurnitureAndSwitchToNextPage();
        } else if (!(this.onePageResults.isEmpty())) {
            createFurniture();
        } else {
            throw new RuntimeException("There isn't any page");
        }
    }

//    protected void createObject() {
//        furnitureManager = new FurnitureManager();
//        for (WebElement onePageResult : onePageResults) {
//            Furniture furniture = new Furniture();
//            furniture.setName(onePageResult.findElement(By.xpath(".//span/span[1]")).getText());
//            furniture.setHref(onePageResult.getAttribute("href"));
//            furnitureManager.create(furniture);
//        }
//    }
//
//    protected void createObjectAndSwitchToNextPage() {
//        while (UiHelper.isElementPresentBy(getBy())) {
//            allResultsNumber += getNumberOfOnePageResult();
//            createObject();
//            UiHelper.clickOnWebElement(nextButton);
//        }
//        allResultsNumber += getNumberOfOnePageResult();
//        createObject();
//    }
//
//    public void addResultsToDB() {
//        if (this.pages.size() > 1) {
//            createObjectAndSwitchToNextPage();
//        } else if (!(this.onePageResults.isEmpty())) {
//            createObject();
//        } else {
//            throw new RuntimeException("There isn't any page");
//        }
//    }

    private int getNumberOfOnePageResult() {
        return onePageResults.size();
    }

    public int getNumberOfDBItems() {
        return furnitureManager.getAll().size();
    }

    public int getNumberOfAllResult() {
        return allResultsNumber;
    }
}
