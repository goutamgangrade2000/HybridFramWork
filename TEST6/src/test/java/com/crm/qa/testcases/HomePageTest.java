package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CartPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class HomePageTest extends TestBase {

    LoginPage loginPage ;
    HomePage homePage;
    CartPage cartPage;


    private HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        loginPage = new LoginPage(driver);
        loginPage.login(prop.getProperty("email"), prop.getProperty("password") );
        homePage = new HomePage(driver);
    }

//    @Test(priority = 1)
//    public void testMenuBar(){
//
//        homePage.validateMenubar();
//        System.out.println("--------2.1");
//    }

    @Test(priority = 2)
    public void testProductText(){

        Assert.assertEquals(homePage.validateProductText(),"Products");
        System.out.println("--------2.2");
    }

    @Test(priority = 3)
    public void testCartLink(){


        boolean flag = homePage.validateHomeCartLink();
        Assert.assertTrue(flag);
        System.out.println("--------2.3");
    }

    @Test(priority = 4)
    public void printAllLinksTest() {
        // Get the list of all links
        List<WebElement> links = homePage.getAllProductText();

        // Print the number of links found
        System.out.println("Number of links on the page: " + links.size());

        // Loop through the list and print each link's text and href attribute
        for (WebElement link : links) {
            System.out.println("Link Text: " + link.getText());
            System.out.println("--------2.4");
        }
    }

    @Test (priority = 5)
    public void checkAddToCart() throws InterruptedException {
        if (homePage.getTextAddtoCart().equals("Add to cart")) {
            homePage.clickAddtoCart();
            Thread.sleep(2000);
            Assert.assertEquals("Remove", homePage.getTextRemove());

            System.out.println("Remove not Click");
        }else {
            System.out.println("Remove Already Click");
        }
        System.out.println("--------2.5");
    }

    @Test (priority = 6)
    public void checkRemove() throws InterruptedException {
        homePage.clickAddtoCart();
        if (homePage.getTextRemove().equals("Remove")) {
            homePage.clickRemove();
            Thread.sleep(2000);
            Assert.assertEquals("Add to cart", homePage.getTextAddtoCart());
            System.out.println("Add to cart not Click");
        }else {
            System.out.println("Add to cart Already Click");
        }
        System.out.println("--------2.6");
    }



    @Test(priority = 7)
    public void validateCartLinkOnClick(){

       cartPage = homePage.validateCartLinkOnClick();

        Assert.assertEquals(cartPage.validateTitleOfCArtPart(),"Your Cart");
        System.out.println("--------2.7");
    }

    @Test(priority = 8)
    public void validateCartPage() throws InterruptedException {

        cartPage=homePage.validateCartLinkOnClick();
        Thread.sleep(2000);
        cartPage.validateTitleOfCArtPart();
        System.out.println("--------2.8");
    }

    @AfterMethod
    public void testDown(){
                driver.close();
    }
}
