package com.pages;

import com.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeHRMLoginPage extends BasePage {

    /*  Locators:
        id
        name
        classname
        linktext
        partiallinktest
        css or xpath
     */

    private final By textboxUsername = By.name("username");
    private final By textboxPassword = By.xpath("//input[@name='password' and @type='password']");
    private final By buttonLogin = By.xpath("//button[@type='submit']");


    public OrangeHRMLoginPage enterUsername(String username){
        sendKeys(textboxUsername,username, WaitStrategy.CLICKABLE, "Username");
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password){
        sendKeys(textboxPassword,password,WaitStrategy.PRESENCE, "Password");
        return this;
    }

    public OrangeHRMHomePage clickLogin() {
        click(buttonLogin, WaitStrategy.CLICKABLE, "Login Button");
        return new OrangeHRMHomePage();
    }

    public String getTitle(){
        return getPageTitle();
    }
}
