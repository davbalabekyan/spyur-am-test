package pages;

import helper_classes.UiHelper;
import jdbc.manager.HotelManager;
import jdbc.model.Hotel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@SuppressWarnings(value = "all")
public class HotelsPage extends BaseSearchPage {

    private int allResultsNumber;
    @FindBy(xpath = "//div[@id='results_list_wrapper']/a")
    private List<WebElement> onePageResults;
    @FindBy(xpath = "//a[@class='next_page']")
    private WebElement nextButton;
    private HotelManager hotelManager;
    @FindBy(xpath = "//div[@class='paging']//ul/li")
    private List<WebElement> pages;

    public HotelsPage(WebDriver webDriver) {
        super(webDriver);
    }

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
            allResultsNumber += getNumberOfOnePageResult();
            createHotel();
            UiHelper.clickOnWebElement(nextButton);
        }
        allResultsNumber += getNumberOfOnePageResult();
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

    public int getNumberOfAllResult() {
        return allResultsNumber;
    }
}
