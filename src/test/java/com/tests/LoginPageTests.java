package com.tests;

import com.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;


public final class LoginPageTests extends BaseTest{

    private LoginPageTests(){}

    @Test
    public void test1() throws InterruptedException {

        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium Automation" + Keys.ENTER);

        String title = DriverManager.getDriver().getTitle();

        assertThat(title)
                .as("Object is not null").isNotNull()
                .as("Contains 'search' keyword").containsIgnoringCase("search")
                .as("length between 15 & 100").hasSizeBetween(15, 100);


        Thread.sleep(2);
        List<WebElement> elements = DriverManager.getDriver().findElements(By.xpath("//h2/a"));

        assertThat(elements)
                .extracting(WebElement :: getText)
                .contains("The Selenium Browser Automation Project");
    }


    @Test
    public void test2(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Gate Smashers" + Keys.ENTER);
    }
}
