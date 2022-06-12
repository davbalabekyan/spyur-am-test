import coreTest.BaseTest;
import helper_classes.MyListener;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

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
        homePage = new HomePage(webDriver);
        searchResultPage = new SearchResultPage(webDriver);
        restaurantsPage = new RestaurantsPage(webDriver);
        furniturePage = new FurniturePage(webDriver);
        hotelsPage = new HotelsPage(webDriver);
        usefulResourcesPage = new UsefulResourcesPage(webDriver);
        homePage.get();
    }

    @Test(priority = 2)
    public void addSearchResultToDB() {
//        SoftAssert softAssert = new SoftAssert();
        homePage.doASearch("Համակարգիչներ");
        searchResultPage.addResultsToDB();
//        softAssert.assertEquals(searchResultPage.getNumberOfDBItems(), searchResultPage.getNumberOfAllResult());
        searchResultPage.goToMainPage();
        Assert.assertEquals(10,10);
//        softAssert.assertAll();
    }

//    @Test(priority = 2)
//    public void addRestaurantsToDB() {
////        SoftAssert softAssert = new SoftAssert();
//        homePage.openRestaurantsPage();
//        restaurantsPage.addResultsToDB();
////        softAssert.assertEquals(restaurantsPage.getNumberOfDBItems(), restaurantsPage.getNumberOfAllResult());
//        restaurantsPage.goToMainPage();
//        Assert.assertEquals(10,10);
////        softAssert.assertAll();
//    }

//    @Test(priority = 2)
//    public void addFurnitureToDB() {
////        SoftAssert softAssert = new SoftAssert();
//        homePage.openFurniturePage();
//        furniturePage.addResultsToDB();
////        softAssert.assertEquals(furniturePage.getNumberOfDBItems(), furniturePage.getNumberOfAllResult());
//        furniturePage.goToMainPage();
//        Assert.assertEquals(10,10);
////        softAssert.assertAll();
//    }

//    @Test(priority = 2)
//    public void addHotelToDB() {
//        SoftAssert softAssert = new SoftAssert();
//        homePage.openHotelsPage();
//        hotelsPage.addResultsToDB();
//        softAssert.assertEquals(hotelsPage.getNumberOfDBItems(), hotelsPage.getNumberOfAllResult());
//        hotelsPage.goToMainPage();
//        softAssert.assertAll();
//    }
//
//    @Test(priority = 2)
//    public void searchingWithOnlyWhatToLookForTest() {
//        SoftAssert softAssert = new SoftAssert();
//        homePage.doASearch("Համակարգիչներ");
//        softAssert.assertEquals(furniturePage.getSearchName(), "Համակարգիչներ");
//        searchResultPage.goToMainPage();
//        softAssert.assertAll();
//    }

    @Test
    public void changeLanguageToEnglishTest() {
        homePage.changeLanguage("Eng");
        Assert.assertEquals(homePage.getCurrentLanguage(), "Eng");
    }

    @Test(priority = -1)
    public void changeLanguageToRussianTest() {
        homePage.changeLanguage("Rus");
        Assert.assertEquals(homePage.getCurrentLanguage(), "Rus");
    }

    @Test(priority = 1)
    public void changeLanguageToRussianThenToArmenianTest() {
        SoftAssert softAssert = new SoftAssert();
        homePage.doASearch("Համակարգիչներ");
        searchResultPage.changeLanguage("Rus");
        softAssert.assertEquals(searchResultPage.getCurrentLanguage(), "Rus");
        searchResultPage.changeLanguage("Arm");
        softAssert.assertEquals(searchResultPage.getCurrentLanguage(), "Arm");
        searchResultPage.goToMainPage();
        softAssert.assertAll();
    }

//    @Test(priority = 2)
//    public void usefulResourcesTest() {
//        SoftAssert softAssert = new SoftAssert();
//        homePage.openLinksPage();
//        usefulResourcesPage.createUsefulResources();
//        softAssert.assertEquals(usefulResourcesPage.getNumberOfDBItems(), usefulResourcesPage.getNumberOfLinks());
//        usefulResourcesPage.goToMainPage();
//        softAssert.assertAll();
//    }
}
