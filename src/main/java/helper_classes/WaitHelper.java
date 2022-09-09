package helper_classes;

import core.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

@SuppressWarnings(value = "all")
public final class WaitHelper {

    private static WebDriver driver = DriverProvider.getDriver();
    private static Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    private static final Logger log = LoggerFactory.getLogger(UiHelper.class);

    private WaitHelper() {
    }

    public static void waitElementToBeClickable(final WebElement target) {
        log.info("Wait element to be clickable...");
        wait.until(ExpectedConditions.elementToBeClickable(target));
    }

    public static void waitElementToBeVisible(final WebElement target) {
        log.info("Wait element to be visible...");
        wait.until(ExpectedConditions.visibilityOf(target));
    }

    public static void waitElementToBeSelected(final WebElement target) {
        log.info("Wait element to be selected...");
        wait.until(ExpectedConditions.elementToBeSelected(target));
    }

    public static void waitElementBeNotVisible(final WebElement target) {
        log.info("Wait element to be not visible...");
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    public static void waitAlertIsPresent() {
        log.info("Wait alert to be present...");
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void waitAttributeContaining(final WebElement target, final String attribute, final String value) {
        log.info("Wait element to contain attribute...");
        wait.until(ExpectedConditions.attributeContains(target, attribute, value));
    }

    public static void waitAttributeToBeNotEmpty(final WebElement target, String attribute) {
        log.info("Wait attribute to be not empty...");
        wait.until(ExpectedConditions.attributeToBeNotEmpty(target, attribute));
    }

    public static void waitTitleIs(final String title) {
        log.info("Wait title is...");
        wait.until(ExpectedConditions.titleIs(title));
    }

    public static void waitTitleContains(final String title) {
        log.info("Wait title to be contain...");
        wait.until(ExpectedConditions.titleContains(title));
    }

    public static void waitUrlToBe(final String url) {
        log.info("Wait url to be...");
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public static void waitUrlContains(final String fraction) {
        log.info("Wait url to be contain...");
        wait.until(ExpectedConditions.urlContains(fraction));
    }

    public static void waitUrlMatches(final String regex) {
        log.info("Wait url to be match...");
        wait.until(ExpectedConditions.urlMatches(regex));
    }

    public static void waitElementsToBeVisible(List<WebElement> elements) {
        log.info("Wait elements to be visible...");
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static void waitElementsNotBeVisible(List<WebElement> elements) {
        log.info("Wait elements to be not visible...");
        wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
    }
}
