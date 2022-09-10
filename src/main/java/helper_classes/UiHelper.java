package helper_classes;

import core.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class UiHelper {

    private static final WebDriver driver = DriverProvider.getDriver();

    private UiHelper() {
    }

    public static void clickOnWebElement(final WebElement target) {
        WaitHelper.waitElementToBeClickable(target);
        WaitHelper.waitElementToBeVisible(target);
        target.click();
    }

    public static void sendKeys(final WebElement input, final String text) {
        WaitHelper.waitElementToBeVisible(input);
        input.sendKeys(text);
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
