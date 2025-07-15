package com.tests;

import com.driver.Driver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.driver.DriverManager;

import java.util.Map;


public class BaseTest{

    protected BaseTest(){}

    @SuppressWarnings("unchecked")
    @BeforeMethod
    protected void setUp(Object[] data) {
        Map<String, String> map = (Map<String, String>)data[0] ;
        Driver.initDriver(map.get("browser"));
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
        DriverManager.unload();
    }
}
