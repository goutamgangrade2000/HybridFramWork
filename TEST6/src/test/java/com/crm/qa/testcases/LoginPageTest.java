package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTest extends TestBase {

    LoginPage loginPage ;
    HomePage homePage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        loginPage = new LoginPage( driver);
    }

    @Test(priority = 1)
    public void loginPageTitleTest(){

        String title = loginPage.validateLoginPage();
        Assert.assertEquals(title,"Swag Labs");
        System.out.println("--------1");
    }

//    @Test(priority = 2)
//    public void logoImageTest(){
////        boolean flag = loginPage.validateLogoImage();
////        Assert.assertTrue(flag);
//        System.out.println("--------2");
//    }

     @Test(priority = 3)
    public void loginTest() {


        //loginPage.login("standard_user","secret_sauce" );
         homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password") );

         System.out.println("--------3");
    }

//    @Test(priority = 4)
//    public void validateHomePageTest(){
//         Assert.assertTrue(homePage.validateLogoImage());
//
//    }


    @AfterMethod
    public void testDown(){
        driver.close();
    }


}
