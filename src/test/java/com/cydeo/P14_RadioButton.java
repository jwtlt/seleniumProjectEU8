package com.cydeo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class P14_RadioButton {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");

        driver.manage().window().maximize();

        WebElement blackRadioButton = driver.findElement(By.cssSelector("input[type='radio'][id='black']"));
        blackRadioButton.click();

        List<WebElement> allRadioButtons = driver.findElements(By.xpath("//label[@class='form-check-label']"));

        for(WebElement each : allRadioButtons){
            System.out.println("each = " + each.getText());
        }

        driver.quit();

    }
}
