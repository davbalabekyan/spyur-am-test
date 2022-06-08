package helper_classes;

import core.Driver;
import org.openqa.selenium.*;

public final class UiHelper {

    private static final WebDriver driver = Driver.getDriverInstance();
    private static final JavascriptExecutor js = (JavascriptExecutor) driver;

    private UiHelper() {
    }

    public static void clickOnWebElement(final WebElement target) {
        scrollToMiddle(target);
        WaitHelper.waitElementToBeClickable(target);
        WaitHelper.waitElementToBeVisible(target);
        target.click();
    }

    private static void scrollToMiddle(final WebElement target) {
        js.executeScript("arguments[0].scrollIntoView({block: 'center'})", target);
    }

    public static boolean isElementPresent(By element) {
        try {
            driver.findElement(element);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
