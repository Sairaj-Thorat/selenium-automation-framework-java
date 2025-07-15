package com.factories;
import com.enums.BrowserType;
import com.enums.ConfigProperties;
import com.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class DriverFactory {

    private DriverFactory(){}

    public static WebDriver getDriver(String browser) throws MalformedURLException {

        WebDriver driver = null ;
        String runmode = PropertyUtils.getValue(ConfigProperties.RUNMODE);

        if (browser.equalsIgnoreCase("edge")){
            if(runmode.equalsIgnoreCase("remote")){
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(BrowserType.EDGE.toString());
                driver =  new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
            }
            else {
                WebDriverManager.edgedriver().setup();
                driver =  new EdgeDriver();
            }
        }

        else if (browser.equalsIgnoreCase("chrome")) {
            if (runmode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(BrowserType.CHROME.toString());
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        }

        else if (browser.equalsIgnoreCase("firefox")) {
            if (runmode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName(BrowserType.FIREFOX.toString());
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
            } else {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }
}
