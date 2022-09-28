package com.cydeo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P07_LocateElementByClassName {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://10fastfingers.com/typing-test/english");


        WebElement text = driver.findElement(By.className("control-label"));

        if(text.getText().equals("Switch Typing Test language")){
            System.out.println("Test Passed");
        }
        else{
            System.out.println("Test Failed");
        }

    }
}
