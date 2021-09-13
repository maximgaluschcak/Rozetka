package com.example.rozetka;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    private final WebDriver driver;
    private final Wait<WebDriver> wait;
    String titleProductText;
    private final By buyButtonLocator = By.xpath("//button[@class='buy-button button button_with_icon button_color_green button_size_large ng-star-inserted']");

    public ProductPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        titleProductText = driver.findElement(By.xpath("//h1[@class='product__title']")).getText();
    }
    public void clickBuyButton(){
        driver.findElement(buyButtonLocator).click();
    }
    public String cartProductTitle(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("cart-product__main")));
        return driver.findElement(By.className("cart-product__main")).getText();
    }

}
