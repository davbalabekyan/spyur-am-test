package helper_classes;

import core.Driver;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenshotHelper {

    private static final WebDriver driver = Driver.getDriverInstance();

    @SneakyThrows
    public static void takeScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File output = screenshot.getScreenshotAs(OutputType.FILE);
        String pathToSaveFile = "src/main/java/core/screenshots/" + System.currentTimeMillis() + ".png";
        File file = new File(pathToSaveFile);
        FileUtils.copyFile(output, file);
    }
}
