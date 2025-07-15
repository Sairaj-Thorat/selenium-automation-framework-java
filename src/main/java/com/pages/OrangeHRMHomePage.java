package com.pages;

import com.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeHRMHomePage extends BasePage{

    private final By buttonUserProfile = By.className("oxd-userdropdown-tab");
    private final By linkLogout = By.xpath("//a[contains(text(),'Logout')]");

    public OrangeHRMLoginPage clickLogout() {
        click(buttonUserProfile, WaitStrategy.CLICKABLE, "User Profile Button");
        click(linkLogout,WaitStrategy.CLICKABLE, "Logout Link");
        return new OrangeHRMLoginPage();
    }
}
