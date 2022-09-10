package pages;

import helper_classes.UiHelper;
import jdbc.manager.FurnitureManager;
import jdbc.model.Furniture;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FurniturePage extends BaseSearchPage {

    private FurnitureManager furnitureManager;

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
            createFurniture();
            UiHelper.clickOnWebElement(nextButton);
        }
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

    private int getNumberOfOnePageResult() {
        return onePageResults.size();
    }

    public int getNumberOfDBItems() {
        return furnitureManager.getAll().size();
    }
}
