package pages;

import helper_classes.UiHelper;
import jdbc.manager.HotelManager;
import jdbc.model.Hotel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HotelsPage extends BaseSearchPage {

    private HotelManager hotelManager;

    private void createHotel() {
        hotelManager = new HotelManager();
        for (WebElement onePageResult : onePageResults) {
            Hotel hotel = new Hotel();
            hotel.setName(onePageResult.findElement(By.xpath(".//span/span[1]")).getText());
            hotel.setHref(onePageResult.getAttribute("href"));
            hotelManager.create(hotel);
        }
    }

    private void createHotelAndSwitchToNextPage() {
        while (UiHelper.isElementPresentBy(getBy())) {
            createHotel();
            UiHelper.clickOnWebElement(nextButton);
        }
        createHotel();
    }

    public void addResultsToDB() {
        if (this.pages.size() > 1) {
            createHotelAndSwitchToNextPage();
        } else if (!(this.onePageResults.isEmpty())) {
            createHotel();
        } else {
            throw new RuntimeException("There isn't any page");
        }
    }

    private int getNumberOfOnePageResult() {
        return onePageResults.size();
    }

    public int getNumberOfDBItems() {
        return hotelManager.getAll().size();
    }
}
