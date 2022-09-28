package com.utility;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class TestBase {

    protected WebDriver driver ;

    @BeforeAll
    public static void initBrowserDriver(){
        System.out.println("@Before All run only once before all test");
    }

    @AfterAll
    public static void teardown(){
        System.out.println("@AfterAll run only once after all test");
    }

    @BeforeEach
    public void setUpBrowser(){
        driver = WebDriverFactory.getDriver("chrome") ;
        driver.manage().window().maximize();
    }

    @AfterEach
    public void cleanUp(){
        //driver.close();
        Driver.closeBrowser();
    }

}
