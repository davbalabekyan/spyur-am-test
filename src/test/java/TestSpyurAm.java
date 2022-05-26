import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultPage;

public class TestSpyurAm extends BaseTest {

    private HomePage homePage;
    private SearchResultPage searchResultPage;

    @BeforeMethod
    public void initPages() {
        homePage = new HomePage();
        searchResultPage = new SearchResultPage();
    }

    @Test
    public void testHomePage() {
        homePage.get();
        homePage.doASearch("Համակարգիչներ");
        String searchName = searchResultPage.getSearchName();
        Assert.assertEquals(searchName, "Համակարգիչներ");
    }

    @Test
    public void testDB1() {
        homePage.get();
        homePage.doASearch("Համակարգիչներ");
        searchResultPage.addResultsToDB();
        Assert.assertEquals(searchResultPage.getNumberOfDBItems(), searchResultPage.getNumberOfAllResult());
    }

    @Test
    public void testDB2() {
        homePage.get();
        homePage.doASearch("Գուլպա", "Գյումրի");
        searchResultPage.addResultsToDB();
        Assert.assertEquals(searchResultPage.getNumberOfDBItems(), searchResultPage.getNumberOfAllResult());
    }

    @Test
    public void testDB3() {
        homePage.get();
        homePage.doASearchOnlyLocation("Վանաձոր ");
        searchResultPage.addResultsToDB();
        Assert.assertEquals(searchResultPage.getNumberOfDBItems(), searchResultPage.getNumberOfAllResult());
    }
}
