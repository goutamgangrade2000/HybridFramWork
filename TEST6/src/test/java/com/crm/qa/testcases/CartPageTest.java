package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CartPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartPageTest extends TestBase {

    LoginPage loginPage ;
    HomePage homePage;
    CartPage cartPage;

    private CartPageTest() {
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        loginPage = new LoginPage(driver);
        loginPage.login(prop.getProperty("email"), prop.getProperty("password") );
        homePage = new HomePage(driver);

    }

    @Test(priority = 1)
    public void validateCartPage() throws InterruptedException {

        homePage.clickAddtoCart();
        homePage.validateCartLinkOnClick();
        cartPage = new CartPage(driver);
        Assert.assertEquals("Sauce Labs Backpack",cartPage.getTextProduct1());
        System.out.println("--------3.1");
    }


    @AfterMethod
    public void testDown(){
        driver.close();
    }

}
