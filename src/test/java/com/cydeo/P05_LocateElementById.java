package com.cydeo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P05_LocateElementById {

    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://youtube.com");

        WebElement searchBox = driver.findElement(By.id("text"));

        String text = searchBox.getAttribute("title");

        if(text.equals("Dimash Kudaibergen")){
            System.out.println("Test Passed");
        }
        else{
            System.out.println("Test Failed");
        }


    }

}
