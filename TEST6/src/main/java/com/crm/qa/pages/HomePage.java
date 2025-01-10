package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class HomePage extends TestBase {

    WebDriver driver;
    CartPage cartPage;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    WebElement menuBarButtom;

    @FindBy(xpath = "//button[@id='react-burger-cross-btn']")
    WebElement menuBarCrossButton;

    @FindBy(xpath = "//span[@class='title']")
    WebElement homeProductText;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement homeCartlink;

    @FindBy(xpath = "//a[@class='inventory_item_name ']")
    private List<WebElement> allProductText;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement homeClickOnAddToCart;

    @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
    WebElement homeClickOnRemove;



    public HomePage(WebDriver driver) {
            this.driver =driver;
        PageFactory.initElements(driver, this);
    }

    //Action
    public void validateMenubar(){
        menuBarButtom.click();
        menuBarCrossButton.click();
    }

    public String validateProductText(){
       return homeProductText.getText();
    }

    public boolean validateHomeCartLink(){
       return homeCartlink.isDisplayed();
    }

    public List<WebElement> getAllProductText()  {
        return allProductText;
    }

    public void clickAddtoCart(){
        homeClickOnAddToCart.click();
    }

    public String getTextAddtoCart(){
        return homeClickOnAddToCart.getText();
    }

    public void clickRemove(){
        homeClickOnRemove.click();
    }

    public String getTextRemove(){
        return homeClickOnRemove.getText();
    }

    public CartPage validateCartLinkOnClick(){
        homeCartlink.click();
        return new CartPage(driver);

    }
}