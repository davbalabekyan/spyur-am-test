package helper_classes;

import core.DriverProvider;
import org.openqa.selenium.*;

public final class UiHelper {

    private static final WebDriver webDriver = DriverProvider.getDriver();

    private UiHelper() {
    }

    public static void clickOnWebElement(final WebElement target) {
        WaitHelper.waitElementToBeClickable(target);
        WaitHelper.waitElementToBeVisible(target);
        target.click();
    }

    public static boolean isElementPresentBy(By element) {
        try {
            webDriver.findElement(element);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
