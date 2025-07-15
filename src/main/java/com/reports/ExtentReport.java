package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.constants.FrameworkConstants;
import com.enums.CategoryType;

import java.awt.*;
import java.io.File;
import java.util.Objects;

public class ExtentReport {

    private static ExtentReports extent ;

    public static void initReports() throws Exception {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            extent.attachReporter(spark);

            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("OrangeHRM Automation");
            spark.config().setReportName("Automation Report - OrangeHRM");
        }
    }

    public static void flushReports() throws Exception {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        ExtentManager.unload();
        Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
    }

    public static void createTest(String testCaseName){
        ExtentTest test = extent.createTest(testCaseName);
        ExtentManager.setExtentTest(test);
    }

    public static void addAuthors(String[] author){
        for(String temp: author){
            ExtentManager.getExtentTest().assignAuthor(temp);
        }
    }

    public static void addCategories(CategoryType[] category){
        for(CategoryType temp: category){
            ExtentManager.getExtentTest().assignCategory(temp.toString());
        }
    }
}
