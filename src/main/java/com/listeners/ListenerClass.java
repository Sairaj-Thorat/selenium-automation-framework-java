package com.listeners;

import com.annotations.FrameworkAnnotation;
import com.reports.ExtentLogger;
import com.reports.ExtentReport;
import org.testng.*;

import java.util.Arrays;


public final class ListenerClass implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        try {
            ExtentReport.initReports();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            ExtentReport.flushReports();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getDescription());

        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod()
                .getMethod().getAnnotation(FrameworkAnnotation.class).author());

        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod()
                .getMethod().getAnnotation(FrameworkAnnotation.class).category());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            ExtentLogger.fail(result.getMethod().getMethodName() + " is failed",true);
            ExtentLogger.fail(result.getThrowable().toString());
            ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        try {
            ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped",true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStart(ITestContext context) {}

    @Override
    public void onFinish(ITestContext context) {}

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {}
}
