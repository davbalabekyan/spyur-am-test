package pages;

import jdbc.manager.ArticleManager;
import jdbc.model.Article;
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
    @FindBy(xpath = "//div[@id='results_list_wrapper']/a/span[@class='result_info']/span[1]")
    private List<WebElement> articleHeaders;
    @FindBy(xpath = "//a[@class='next_page']")
    private WebElement nextButton;

    public int numberOfResult() {
        return this.searchResult.size();
    }

    private void createArticle() {
        this.articleManager = new ArticleManager();
        for (int i = 0; i < searchResult.size(); i++) {
            Article article = new Article();
            String header = articleHeaders.get(i).getText();
            article.setName(header);
            article.setHref(searchResult.get(i).getAttribute("href"));
            this.articleManager.create(article);
        }
    }

    private void createArticleAndSwitchToNextPage() {
        for (int i = 0; i < this.pages.size() - 1; i++) {
            createArticle();
            if (i != this.pages.size() - 2) {
                this.nextButton.click();
            }
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
