package pages;

import helper_classes.UiHelper;
import jdbc.manager.ArticleManager;
import jdbc.model.Article;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends BaseSearchPage {

    private ArticleManager articleManager;

    private void createArticle() {
        this.articleManager = new ArticleManager();
        for (WebElement element : onePageResults) {
            Article article = new Article();
            WebElement header = element.findElement(By.xpath(".//span/span[1]"));
            article.setName(header.getText());
            article.setHref(element.getAttribute("href"));
            this.articleManager.create(article);
        }
    }

    private void createArticleAndSwitchToNextPage() {
        while (UiHelper.isElementPresentBy(getBy())) {
            createArticle();
            UiHelper.clickOnWebElement(nextButton);
        }
        createArticle();
    }

    public void addResultsToDB() {
        if (this.pages.size() > 1) {
            createArticleAndSwitchToNextPage();
        } else if (!(this.onePageResults.isEmpty())) {
            createArticle();
        } else {
            throw new RuntimeException("There isn't any page");
        }
    }

    private int getNumberOfOnePageResult() {
        return onePageResults.size();
    }

    public int getNumberOfDBItems() {
        return articleManager.getAll().size();
    }
}
