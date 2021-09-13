package com.example.rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final Wait<WebDriver> wait;
    private final WebDriver driver;
    private final By hrefProductLocator = By.xpath("//a[@class='tile__title']");
    private final By productLocator = By.xpath("//li[@class='main-goods__cell ng-star-inserted']");
    private final By wrongEmailMessageLocator = By.xpath("//p[@class='error-message ng-star-inserted']");
    private final By lgButtonLocator = By.xpath("//button[@class='header__button ng-star-inserted']");
    private final By enterButtonLocator = By.xpath("//button[@class='button button--large button--green auth-modal__submit ng-star-inserted']");
    private final By emailInputLocator = By.xpath("//input[@id='auth_email']");
    private final By passwordInputLocator = By.xpath("//input[@id='auth_pass']");
    private final By bannerLocator = By.xpath("//a[@class='exponea-banner exponea-popup-banner exponea-animate']");
    private final By hiddenMenuLocator = By.xpath("//div[@class='menu__hidden-column menu__hidden-column_color_gray ng-star-inserted']");
    private final By catalogMenuButtonLocator = By.xpath("//button[@class='button button--medium button--with-icon menu__toggle ng-star-inserted']");
    private final By menuButtonLocator = By.xpath("//button[@class='header__button']");
    private final By socialListLocator = By.xpath("//ul[@class='socials__list']");

    public MainPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
    public boolean checkSocialList(){
        wait.until(ExpectedConditions.elementToBeClickable(socialListLocator));
        return driver.findElement(socialListLocator).isDisplayed();
    }
    public void clickMenuButton(){
        driver.findElement(menuButtonLocator).click();
    }
    public void clickCatalogMenuButton(){
        driver.findElement(catalogMenuButtonLocator).click();
    }
    public void clickLoginButton(){
        driver.findElement(lgButtonLocator).click();
    }
    public void inputPass(String pass){
        wait.until(ExpectedConditions.presenceOfElementLocated(passwordInputLocator));
        driver.findElement(passwordInputLocator).sendKeys(pass);
    }
    public void inputEmail(String email){
        wait.until(ExpectedConditions.presenceOfElementLocated(emailInputLocator));
        driver.findElement(emailInputLocator).sendKeys(email);
    }
    public boolean wrongEmailMessageIsEnable(){
        return driver.findElement(wrongEmailMessageLocator).isDisplayed();
    }
    public ProductPage clickOnFirstProduct(){
        String href = driver.findElements(productLocator).get(0).findElement(hrefProductLocator).getAttribute("href");
        driver.findElements(productLocator).get(0).click();
        driver.get(href);
        return new ProductPage(driver);
    }
    public boolean checkBanner(){
        wait.until(ExpectedConditions.presenceOfElementLocated(bannerLocator));
        return driver.findElement(bannerLocator).isDisplayed();
    }
    public boolean checkCatalogMenu(){
        wait.until(ExpectedConditions.presenceOfElementLocated(hiddenMenuLocator));
        return driver.findElement(hiddenMenuLocator).isEnabled();
    }
}
