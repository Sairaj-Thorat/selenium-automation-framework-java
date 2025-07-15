/**
 * @author : Sairaj Sanjay Thorat
 * @version : 1.0.0
 */

package com.driver;

import org.openqa.selenium.WebDriver;


public final class DriverManager {

    private DriverManager(){}

    private final static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return dr.get();
    }

    public static void setDriver(WebDriver driverRef){
        dr.set(driverRef);
    }

    public static void unload(){
        dr.remove();
    }

}
