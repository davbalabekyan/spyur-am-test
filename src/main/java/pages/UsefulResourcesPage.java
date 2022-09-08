package pages;

import jdbc.manager.UsefulResourceManager;
import jdbc.model.UsefulResource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@SuppressWarnings(value = "all")
public class UsefulResourcesPage extends BaseSearchPage {

    private UsefulResourceManager manager;
    @FindBy(xpath = "//div[@id='textplace']/ul/li")
    private List<WebElement> webElementList;
    @FindBy(xpath = "//div[@class='main_logo']/a")
    private WebElement homePageButton;

    public void createUsefulResources() {
        manager = new UsefulResourceManager();
        for (WebElement element : webElementList) {
            UsefulResource usefulResource = new UsefulResource();
            usefulResource.setName(element.findElement(By.xpath("./a")).getText());
            usefulResource.setHref(element.findElement(By.xpath("./a")).getAttribute("href"));
            manager.create(usefulResource);
        }
    }

    public int getNumberOfLinks() {
        return webElementList.size();
    }

    public int getNumberOfDBItems() {
        return manager.getAll().size();
    }
}
