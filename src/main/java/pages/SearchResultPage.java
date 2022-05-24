package pages;

import core.UiHelper;
import jdbc.manager.ArticleManager;
import jdbc.model.Article;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@SuppressWarnings(value = "all")
public class SearchResultPage extends BasePage {

    private ArticleManager articleManager;
    @FindBy(xpath = "//div[@id='results_list_wrapper']/a")
    private List<WebElement> searchResult;
    @FindBy(xpath = "//div[@class='paging']//ul/li")
    private List<WebElement> pages;
    ;
    @FindBy(xpath = "//a[@class='next_page']")
    private WebElement nextButton;

    public int numberOfResult() {
        return this.searchResult.size();
    }

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
        try {
            while (this.nextButton.isDisplayed()) {
                createArticle();
                UiHelper.clickOnWebElement(nextButton);
            }
        } catch (NoSuchElementException e) {
            createArticle();
            return;
        }
    }

    public void addResultsToDB() {
        if (this.pages.size() > 1) {
            createArticleAndSwitchToNextPage();
        } else if (!(this.searchResult.isEmpty())) {
            createArticle();
        } else {
            throw new RuntimeException("There is'nt any page");
        }
    }
}
