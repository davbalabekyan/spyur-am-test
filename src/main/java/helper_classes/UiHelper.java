package helper_classes;

import core.DriverProvider;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class UiHelper {

    private static final WebDriver driver = DriverProvider.getDriver();
    private static final JavascriptExecutor js = (JavascriptExecutor) driver;
    private static final Logger log = LoggerFactory.getLogger(UiHelper.class);

    private UiHelper() {
    }

    public static void clickOnWebElement(final WebElement target) {
        WaitHelper.waitElementToBeClickable(target);
        WaitHelper.waitElementToBeVisible(target);
        log.info("CLick on web element...");
        target.click();
    }

    public static void sendKeys(final WebElement input, final String text) {
        WaitHelper.waitElementToBeVisible(input);
        log.info("Typing in input..");
        input.sendKeys(text);
    }

    public static void scrollToWebElement(final WebElement target) {
        log.info("Scroll to web element...");
        js.executeScript("arguments[0].scrollIntoView(true);", target);
    }

    public static boolean isElementPresentBy(By element) {
        try {
            log.info("Trying to find web element");
            driver.findElement(element);
            log.info("Web element has found!");
            return true;
        } catch (NoSuchElementException e) {
            log.error("Web element not found");
            return false;
        }
    }
}
