package com.cydeo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P02_CloseAndQuitBrowser {

    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // this practice url will open  and wait 3 seconds and open new tab
        driver.get("https://practice.cydeo.com/open_new_tab");

        //wait 5 seconds
            Thread.sleep(5000);

        // closing the current tab
        driver.close();

        //close all browser window opened by driver
        //driver.quit();

    }
}
