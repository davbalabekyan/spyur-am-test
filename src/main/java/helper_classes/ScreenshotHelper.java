package helper_classes;

import core.DriverProvider;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class ScreenshotHelper {

    private static final WebDriver webDriver = DriverProvider.getDriver();
    private static final Logger log = LoggerFactory.getLogger(ScreenshotHelper.class);

    private ScreenshotHelper() {
    }

    public static void takeScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot) webDriver;
        try {
            File output = screenshot.getScreenshotAs(OutputType.FILE);
            String pathToSaveFile = "src/main/java/core/screenshots/" + System.currentTimeMillis() + ".png";
            File file = new File(pathToSaveFile);
            FileUtils.copyFile(output, file);
        } catch (IOException ignored) {
            log.error("Error while copying file");
        }
    }
}
