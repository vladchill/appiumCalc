package com.qatestlab.calc;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static AndroidDriver driver;


    public static AndroidDriver getDriver() {
        return driver;
    }


    @BeforeClass
    public void setUp() throws MalformedURLException {

        String apkPath = System.getProperty("calc.path");

        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("platformName","Android");
//        caps.setCapability("autoLaunch","false");
//        caps.setCapability("app",apkPath);
        caps.setCapability("appPackage","com.android2.calculator3");
        caps.setCapability("appActivity",".Calculator");
//        caps.setCapability("browserName","Browser");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().window().maximize();

    }

    @AfterClass
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
