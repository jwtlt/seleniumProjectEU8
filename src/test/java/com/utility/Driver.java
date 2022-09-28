package com.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver{

    private static WebDriver driver;

    private Driver(){}

    public static WebDriver getDriver(){

        if (driver == null){

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            return driver;
        }

        return driver;

    }

    public static void closeBrowser(){

        if(driver != null) {
            driver.quit();
            driver = null;
        }

    }

}