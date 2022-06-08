import coreTest.BaseTest;
import helper_classes.MyListener;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

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

    @Test()
    public void addSearchResultToDB() {
        homePage.doASearch("Համակարգիչներ");
        searchResultPage.addResultsToDB();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(searchResultPage.getNumberOfDBItems(), searchResultPage.getNumberOfAllResult());
        searchResultPage.goToMainPage();
        softAssert.assertAll();
    }

    @Test()
    public void addRestaurantsToDB() {
        homePage.openRestaurantsPage();
        restaurantsPage.addResultsToDB();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(restaurantsPage.getNumberOfDBItems(), restaurantsPage.getNumberOfAllResult());
        restaurantsPage.goToMainPage();
        softAssert.assertAll();
    }

    @Test()
    public void addFurnitureToDB() {
        homePage.openFurniturePage();
        furniturePage.addResultsToDB();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(furniturePage.getNumberOfDBItems(), furniturePage.getNumberOfAllResult());
        furniturePage.goToMainPage();
        softAssert.assertAll();
    }

    @Test()
    public void addHotelToDB() {
        homePage.openHotelsPage();
        hotelsPage.addResultsToDB();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(hotelsPage.getNumberOfDBItems(), hotelsPage.getNumberOfAllResult());
        hotelsPage.goToMainPage();
        softAssert.assertAll();
    }

    @Test()
    public void searchingWithOnlyWhatToLookForTest() {
        System.out.println("Thread ID " + Thread.currentThread().getId());
        homePage.doASearch("Համակարգիչներ");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(furniturePage.getSearchName(), "Համակարգիչներ");
        searchResultPage.goToMainPage();
        softAssert.assertAll();

    }

//    @Test
//    public void changeLanguageToEnglishTest() {
//        homePage.changeLanguage("Eng");
//        Assert.assertEquals(homePage.getCurrentLanguage(), "Eng");
//    }
//
//    @Test(priority = -1)
//    public void changeLanguageToRussianTest() {
//        homePage.changeLanguage("Rus");
//        Assert.assertEquals(homePage.getCurrentLanguage(), "Rus");
//    }
//
//    @Test(priority = 1)
//    public void changeLanguageToRussianThenToArmenianTest() {
//        SoftAssert softAssert = new SoftAssert();
//        homePage.doASearch("Համակարգիչներ");
//        searchResultPage.changeLanguage("Rus");
//        softAssert.assertEquals(searchResultPage.getCurrentLanguage(), "Rus");
//        searchResultPage.changeLanguage("Arm");
//        softAssert.assertEquals(searchResultPage.getCurrentLanguage(), "Arm");
//        searchResultPage.goToMainPage();
//        softAssert.assertAll();
//    }
//
//    @Test()
//    public void usefulResourcesTest() {
//        homePage.openLinksPage();
////        usefulResourcesPage.createUsefulResources();
//        SoftAssert softAssert = new SoftAssert();
////        softAssert.assertEquals(usefulResourcesPage.getNumberOfDBItems(), usefulResourcesPage.getNumberOfLinks());
//        softAssert.assertEquals(10, 10);
//        usefulResourcesPage.goToMainPage();
//        softAssert.assertAll();
//    }
}
