package helper_classes;

import core.Driver;
import org.openqa.selenium.*;

public final class UiHelper {

    private static final WebDriver driver = Driver.getDriverInstance();

    private UiHelper() {
    }

    public static void clickOnWebElement(final WebElement target) {
        WaitHelper.waitElementToBeClickable(target);
        WaitHelper.waitElementToBeVisible(target);
        target.click();
    }

    public static boolean isElementPresentBy(By element) {
        try {
            driver.findElement(element);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
