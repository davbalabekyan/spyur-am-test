package helper_classes;

import core.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings(value = "all")
public final class ActionHelper {

    private static WebDriver driver = DriverProvider.getDriver();
    private static final Actions actions = new Actions(driver);
    private static final Logger log = LoggerFactory.getLogger(ActionHelper.class);

    private ActionHelper() {
    }

    public static void dragAndDrop(final WebElement source, final WebElement target) {
        log.info("Drag and drop web element");
        actions
                .dragAndDrop(source, target)
                .build()
                .perform();
    }

    public static void contentClick(final WebElement target) {
        log.info("Right click on web element");
        actions
                .contextClick(target)
                .build()
                .perform();
    }

    public static void doubleClick(final WebElement target) {
        log.info("Double click on web element");
        actions
                .doubleClick(target)
                .build()
                .perform();
    }
}
