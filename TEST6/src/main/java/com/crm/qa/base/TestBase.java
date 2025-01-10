package com.crm.qa.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.qa.util.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentSparkReporter sparkReporter;

    public TestBase(){
        try {
            prop = new Properties();
            FileInputStream ip =new FileInputStream("C:\\Users\\MY PC\\IdeaProjects\\TEST6\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void initialization(){
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")){
            System.getProperty("webdriver.chrome.driver","C:/Users/MY PC/Downloads/ChromeSetup");
            driver = new ChromeDriver();

        } else if (browserName.equals("edge")){
            System.getProperty("webdriver.edge.driver","C:/ProgramData/Microsoft/Windows/Start Menu/Programs/Microsoft Edge");
            driver = new EdgeDriver();
        }

        // Initialize ExtentSparkReporter (this generates the report)
        sparkReporter = new ExtentSparkReporter("extent-report.html");
        sparkReporter.config().setReportName("Extent Report - Selenium Tests");
        sparkReporter.config().setDocumentTitle("Automation Report");

        // Initialize ExtentReports and attach the reporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Add some environment info to the report
        extent.setSystemInfo("OS", "Windows 11");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("Tester", "Goutam");


        test = extent.createTest("Google Search Test", "Test to search in Google");

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Utility.Page_Load_TimeOut, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
        test.info("Navigated to Swag lab");
        test.pass("url test passed");

    }
}
