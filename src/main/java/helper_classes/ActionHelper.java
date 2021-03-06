package helper_classes;

import core.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.internal.BaseTestMethod;

@SuppressWarnings(value = "all")
public final class ActionHelper {

    private static WebDriver driver = null;

//    todo get driver
    private static final Actions actions = new Actions(driver);

    private ActionHelper() {
    }

    public static void dragAndDrop(final WebElement source, final WebElement target) {
        actions
                .dragAndDrop(source, target)
                .build()
                .perform();
    }

    public static void contentClick(final WebElement target) {
        actions
                .contextClick(target)
                .build()
                .perform();
    }

    public static void doubleClick(final WebElement target) {
        actions
                .doubleClick(target)
                .build()
                .perform();
    }
}
