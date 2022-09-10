package helper_classes;

import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class MyListener implements ITestNGListener, ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        ScreenshotHelper.takeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }
}
