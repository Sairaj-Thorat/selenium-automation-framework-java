package com.tests;

import com.driver.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class HomepageTests extends BaseTest{

    private HomepageTests(){}

    @Test
    public void test3(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("code with harry" + Keys.ENTER);
    }

    @Test
    public void test4(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Emergys solutions pune" + Keys.ENTER);
    }
}
