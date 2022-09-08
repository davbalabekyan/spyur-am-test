package pages;

import helper_classes.UiHelper;
import jdbc.manager.ArticleManager;
import jdbc.model.Article;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@SuppressWarnings(value = "all")
public class SearchResultPage extends BaseSearchPage {

    private int allResultOfSearch;
    private ArticleManager articleManager;
    @FindBy(xpath = "//div[@id='results_list_wrapper']/a")
    private List<WebElement> searchResult;
    @FindBy(xpath = "//div[@class='paging']//ul/li")
    private List<WebElement> pages;
    @FindBy(xpath = "//a[@class='next_page']")
    private WebElement nextButton;

    private void createArticle() {
        this.articleManager = new ArticleManager();
        for (WebElement element : searchResult) {
            Article article = new Article();
            WebElement header = element.findElement(By.xpath(".//span/span[1]"));
            article.setName(header.getText());
            article.setHref(element.getAttribute("href"));
            this.articleManager.create(article);
        }
    }

    private void createArticleAndSwitchToNextPage() {
        while (UiHelper.isElementPresentBy(getBy())) {
            allResultOfSearch += getNumberOfOnePageResult();
            createArticle();
            UiHelper.clickOnWebElement(nextButton);
        }
        allResultOfSearch += getNumberOfOnePageResult();
        createArticle();
    }

    public void addResultsToDB() {
        if (this.pages.size() > 1) {
            createArticleAndSwitchToNextPage();
        } else if (!(this.searchResult.isEmpty())) {
            createArticle();
            allResultOfSearch += getNumberOfOnePageResult();
        } else {
            throw new RuntimeException("There isn't any page");
        }
    }

    private int getNumberOfOnePageResult() {
        return searchResult.size();
    }

    public int getNumberOfDBItems() {
        return articleManager.getAll().size();
    }

    public int getNumberOfAllResult() {
        return allResultOfSearch;
    }
}
