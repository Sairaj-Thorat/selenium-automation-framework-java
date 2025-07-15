package com.driver;

import com.enums.ConfigProperties;
import com.exceptions.BrowserInvocationFailedException;
import com.factories.DriverFactory;
import com.utils.PropertyUtils;

import java.net.MalformedURLException;
import java.util.Objects;

public class Driver {

    public static void initDriver(String browser) {
        if (Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverFactory.getDriver(browser);
            } catch (MalformedURLException e) {
                throw new BrowserInvocationFailedException("Please check browser capabilities.");
            }
            DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));
            DriverManager.getDriver().manage().window().maximize();
        }
    }

    public static void quitDriver(){
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
