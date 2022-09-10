package pages;

import helper_classes.UiHelper;
import jdbc.manager.RestaurantManager;
import jdbc.model.Restaurant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RestaurantsPage extends BaseSearchPage {

    private RestaurantManager restaurantManager;

    private void createRestaurant() {
        restaurantManager = new RestaurantManager();
        for (WebElement onePageResult : onePageResults) {
            Restaurant restaurant = new Restaurant();
            restaurant.setName(onePageResult.findElement(By.xpath(".//span/span[1]")).getText());
            restaurant.setHref(onePageResult.getAttribute("href"));
            restaurantManager.create(restaurant);
        }
    }

    private void createRestaurantAndSwitchToNextPage() {
        while (UiHelper.isElementPresentBy(getBy())) {
            createRestaurant();
            UiHelper.clickOnWebElement(nextButton);
        }
        createRestaurant();
    }

    public void addResultsToDB() {
        if (this.pages.size() > 1) {
            createRestaurantAndSwitchToNextPage();
        } else if (!(this.onePageResults.isEmpty())) {
            createRestaurant();
        } else {
            throw new RuntimeException("There isn't any page");
        }
    }

    private int getNumberOfOnePageResult() {
        return onePageResults.size();
    }

    public int getNumberOfDBItems() {
        return restaurantManager.getAll().size();
    }
}
