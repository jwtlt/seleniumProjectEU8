package com.cydeo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P11_LocateElementByCssSelector {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://search.yahoo.com/");
        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.cssSelector("#sbq-wrap>#yschsp"));
        searchBox.sendKeys("css selector");

        WebElement clearIcon = driver.findElement(By.cssSelector("button[type='button'][class='sbq-x']>span"));
        clearIcon.click();

        searchBox.sendKeys("riot");

        WebElement search = driver.findElement(By.cssSelector("#sf > button > span"));
        search.click();

        driver.quit();

    }
}
