package helper_classes;

import core.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public final class WaitHelper {

    private static final WebDriver driver = DriverProvider.getDriver();
    private static final Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    private WaitHelper() {
    }

    public static void waitElementToBeClickable(final WebElement target) {
        wait.until(ExpectedConditions.elementToBeClickable(target));
    }

    public static void waitElementToBeVisible(final WebElement target) {
        wait.until(ExpectedConditions.visibilityOf(target));
    }

    public static void waitElementToBeSelected(final WebElement target) {
        wait.until(ExpectedConditions.elementToBeSelected(target));
    }

    public static void waitElementBeNotVisible(final WebElement target) {
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    public static void waitAlertIsPresent() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void waitAttributeContaining(final WebElement target, final String attribute, final String value) {
        wait.until(ExpectedConditions.attributeContains(target, attribute, value));
    }

    public static void waitAttributeToBeNotEmpty(final WebElement target, String attribute) {
        wait.until(ExpectedConditions.attributeToBeNotEmpty(target, attribute));
    }

    public static void waitTitleIs(final String title) {
        wait.until(ExpectedConditions.titleIs(title));
    }

    public static void waitTitleContains(final String title) {
        wait.until(ExpectedConditions.titleContains(title));
    }

    public static void waitUrlToBe(final String url) {
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public static void waitUrlContains(final String fraction) {
        wait.until(ExpectedConditions.urlContains(fraction));
    }

    public static void waitUrlMatches(final String regex) {
        wait.until(ExpectedConditions.urlMatches(regex));
    }

    public static void waitElementsToBeVisible(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static void waitElementsNotBeVisible(List<WebElement> elements) {
        wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
    }
}
