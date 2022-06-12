package helper_classes;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

public class MyListener implements ITestNGListener, ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println(iTestResult.getMethod().getMethodName() +
                " test start in thread " + Thread.currentThread().getId());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println(iTestResult.getMethod().getMethodName() +
                " test success in thread " + Thread.currentThread().getId());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println(iTestResult.getMethod().getMethodName() +
                " test failed in thread " + Thread.currentThread().getId());
        ScreenshotHelper.takeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println(iTestResult.getMethod().getMethodName() +
                " test skipped in thread " + Thread.currentThread().getId());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }
}
