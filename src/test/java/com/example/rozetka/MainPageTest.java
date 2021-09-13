package com.example.rozetka;

import org.testng.annotations.*;

import static org.testng.Assert.*;

public class MainPageTest extends BaseTest {

    @Test
    public void login() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickLoginButton();
        mainPage.inputEmail(wrongEmail);
        mainPage.inputPass(wrongPass);
        assertTrue(mainPage.wrongEmailMessageIsEnable());
    }
    @Test
    public void addToBasket() {
        MainPage mainPage = new MainPage(getDriver());
        ProductPage productPage = mainPage.clickOnFirstProduct();
        productPage.clickBuyButton();
        assertEquals(productPage.cartProductTitle(), productPage.titleProductText);
    }
    @Test
    public void checkBanner() {
        MainPage mainPage = new MainPage(getDriver());
        assertTrue(mainPage.checkBanner());
    }
    @Test
    public void checkCatalogMenu() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickCatalogMenuButton();
        assertTrue(mainPage.checkCatalogMenu());
    }
    @Test
    public void checkSocialList() {
        MainPage mainPage = new MainPage(getDriver());
        mainPage.clickMenuButton();
        assertTrue(mainPage.checkSocialList());
    }

}
