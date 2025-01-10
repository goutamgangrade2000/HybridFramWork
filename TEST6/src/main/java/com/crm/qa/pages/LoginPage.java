package com.crm.qa.pages;


import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    WebDriver driver ;
    HomePage homePage;

    //Page Factory

    @FindBy(xpath = "//input[@id='user-name']")
    WebElement email ;


    @FindBy(xpath = "//input[@id='password']")
    WebElement passWord ;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement loginButton ;

    @FindBy(xpath = "//span[@class='title']")
    WebElement homeLogoImage;



    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }


    //Action
    public String validateLoginPage(){
        return driver.getTitle();
    }

    public boolean validateLogoImage(){
        return homeLogoImage.isDisplayed();
    }

    public HomePage login(String em, String pw){

        email.sendKeys(em);
        passWord.sendKeys(pw);
        loginButton.click();

        return new HomePage(driver);
    }
}
