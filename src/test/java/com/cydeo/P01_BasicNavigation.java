package com.cydeo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P01_BasicNavigation {

    public static void main(String[] args) {

        // Setting up the web driver manager
        WebDriverManager.chromedriver().setup();

        // Create instance of the chrome driver
        WebDriver driver = new ChromeDriver();

        // Test if the driver is working as expected
        driver.navigate().to("https://www.google.com");

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();
    }
}
