package helper_classes;

import core.DriverProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotHelper {

    private static final WebDriver webDriver = DriverProvider.getDriver();

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
        }
    }
}
