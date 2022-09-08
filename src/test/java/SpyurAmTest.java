import coreTest.BaseTest;
import helper_classes.MyListener;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import static org.testng.Assert.assertEquals;

@SuppressWarnings(value = "all")
@Listeners(MyListener.class)
public class SpyurAmTest extends BaseTest {

    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private RestaurantsPage restaurantsPage;
    private FurniturePage furniturePage;
    private HotelsPage hotelsPage;
    private UsefulResourcesPage usefulResourcesPage;

    @BeforeTest
    public void initPages() {
        homePage = new HomePage();
        searchResultPage = new SearchResultPage();
        restaurantsPage = new RestaurantsPage();
        furniturePage = new FurniturePage();
        hotelsPage = new HotelsPage();
        usefulResourcesPage = new UsefulResourcesPage();
        homePage.get();
    }

    @Test(priority = 2)
    public void addSearchResultToDB() throws InterruptedException {
        homePage.doASearch("Համակարգիչներ");
        searchResultPage.addResultsToDB();
        assertEquals(searchResultPage.getNumberOfDBItems(), searchResultPage.getNumberOfAllResult());
        searchResultPage.goToMainPage();
    }

    @Test(priority = 2)
    public void addRestaurantsToDB() {
        homePage.openRestaurantsPage();
        restaurantsPage.addResultsToDB();
        assertEquals(restaurantsPage.getNumberOfDBItems(), restaurantsPage.getNumberOfAllResult());
        restaurantsPage.goToMainPage();
    }

    @Test(priority = 2)
    public void addFurnitureToDB() {
        homePage.openFurniturePage();
        furniturePage.addResultsToDB();
        assertEquals(furniturePage.getNumberOfDBItems(), furniturePage.getNumberOfAllResult());
        furniturePage.goToMainPage();
    }

    @Test(priority = 2)
    public void addHotelToDB() {
        homePage.openHotelsPage();
        hotelsPage.addResultsToDB();
        assertEquals(hotelsPage.getNumberOfDBItems(), hotelsPage.getNumberOfAllResult());
        hotelsPage.goToMainPage();
    }

    @Test(priority = 2)
    public void searchingWithOnlyWhatToLookForTest() {
        homePage.doASearch("Համակարգիչներ");
        assertEquals(furniturePage.getSearchName(), "Համակարգիչներ");
        searchResultPage.goToMainPage();
    }

    @Test
    public void changeLanguageToEnglishTest() {
        homePage.changeLanguage("Eng");
        assertEquals(homePage.getCurrentLanguage(), "Eng");
    }

    @Test(priority = -1)
    public void changeLanguageToRussianTest() {
        homePage.changeLanguage("Rus");
        assertEquals(homePage.getCurrentLanguage(), "Rus");
    }

    @Test(priority = 1)
    public void changeLanguageToRussianThenToArmenianTest() {
        homePage.doASearch("Համակարգիչներ");
        searchResultPage.changeLanguage("Rus");
        assertEquals(searchResultPage.getCurrentLanguage(), "Rus");
        searchResultPage.changeLanguage("Arm");
        assertEquals(searchResultPage.getCurrentLanguage(), "Arm");
        searchResultPage.goToMainPage();
    }

    @Test(priority = 2)
    public void usefulResourcesTest() {
        homePage.openLinksPage();
        usefulResourcesPage.createUsefulResources();
        assertEquals(usefulResourcesPage.getNumberOfDBItems(), usefulResourcesPage.getNumberOfLinks());
        usefulResourcesPage.goToMainPage();
    }
}
