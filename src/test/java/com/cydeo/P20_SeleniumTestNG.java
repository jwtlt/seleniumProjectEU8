package com.cydeo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class P20_SeleniumTestNG {

    WebDriver driver;

        @BeforeMethod
        public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        }
    
        @Test
        public void testHomePage() throws InterruptedException {

            driver.get("https://google.com");
            Thread.sleep(2000);

            Assert.assertEquals(driver.getTitle(),"Google");

            Thread.sleep(2000);

        }

        @AfterMethod
        public void cleanup(){

        driver.close();

        }

}
