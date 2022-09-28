package com.cydeo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P13_Checkbox {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/checkboxes");

        driver.manage().window().maximize();

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='box1']"));

        if (!checkbox1.isSelected()){
            checkbox1.click();
        }

        WebElement checkbox2 = driver.findElement(By.xpath("\"//input[@id='box2']\""));

        if(!checkbox2.isSelected()){
            checkbox2.click();
        }

        System.out.println("checkbox1 = " + checkbox1);
        System.out.println("checkbox2 = " + checkbox2);

        driver.quit();

    }
}
