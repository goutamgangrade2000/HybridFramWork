package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    @FindBy(xpath = "//span[@class='title']")
    WebElement cartPagetitle;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    WebElement product1;

    public CartPage(WebDriver driver) {
            this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    //Action
    public String validateTitleOfCArtPart(){
        return cartPagetitle.getText();
    }

    public String getTextProduct1(){
        return product1.getText();
    }





}

