package helper_classes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class MyListener implements ITestNGListener, ITestListener {

    private static final Logger log = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info(iTestResult.getMethod().getMethodName() + " test start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info(iTestResult.getMethod().getMethodName() + " test success");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info(iTestResult.getMethod().getMethodName() + " test failed");
        ScreenshotHelper.takeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info(iTestResult.getMethod().getMethodName() + " test skipped");
    }
}
