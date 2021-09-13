package com.example.rozetka;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static ThreadLocal<ChromeDriver> driver = new ThreadLocal<>();
    protected String wrongEmail = "123123";
    protected String wrongPass = "123123";
    @BeforeMethod
    public void setUp(){
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver",
                "src/resources/chromedriver.exe");
        driver.set(new ChromeDriver(ops));
    }
    public WebDriver getDriver(){
        driver.get().manage().window().setSize(new Dimension(1280, 720));
        driver.get().get("https://rozetka.com.ua/");
        return driver.get();
    }
    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }
}
