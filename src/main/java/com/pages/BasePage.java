package com.pages;

import com.driver.DriverManager;
import com.enums.WaitStrategy;
import com.factories.ExplicitWaitFactory;
import com.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        element.click();
        try {
            ExtentLogger.pass(elementName + " is clicked",true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(by, waitStrategy);
        element.sendKeys(value);
        try {
            ExtentLogger.pass(value + " is entered successfully in " + elementName, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }

}
