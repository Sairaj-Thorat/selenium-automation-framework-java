package com.factories;

import com.constants.FrameworkConstants;
import com.driver.DriverManager;
import com.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitFactory {

    public static WebElement performExplicitWait(By by, WaitStrategy waitStrategy) {
        WebElement element = null ;
        Duration explicitWaitTime = Duration.ofSeconds(FrameworkConstants.getExplicitWait()) ;

        if (waitStrategy == WaitStrategy.CLICKABLE) {
            element = new WebDriverWait(DriverManager.getDriver(), explicitWaitTime).
                    until(ExpectedConditions.elementToBeClickable(by));

        } else if (waitStrategy == WaitStrategy.PRESENCE) {
            element = new WebDriverWait(DriverManager.getDriver(),explicitWaitTime).
                    until(ExpectedConditions.presenceOfElementLocated(by));

        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            element = new WebDriverWait(DriverManager.getDriver(), explicitWaitTime).
                    until(ExpectedConditions.visibilityOfElementLocated(by));

        } else if (waitStrategy == WaitStrategy.NONE) {
            element = DriverManager.getDriver().findElement(by);
        }

        return element;
    }
}
