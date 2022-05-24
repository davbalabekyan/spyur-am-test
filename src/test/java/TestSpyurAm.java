import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultPage;

public class TestSpyurAm {

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
    }

    @Test
    public void testDB1() {
        homePage.get();
        homePage.doASearch("Համակարգիչներ");
        searchResultPage.addResultsToDB();
    }

    @Test
    public void testDB2() {
        homePage.get();
        homePage.doASearch("Գուլպա", "Գյումրի");
        searchResultPage.addResultsToDB();
    }

    @Test
    public void testDB3(){
        homePage.get();
        homePage.doASearchOnlyLocation("Վանաձոր ");
        searchResultPage.addResultsToDB();
    }
}
