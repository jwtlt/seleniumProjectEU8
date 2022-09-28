package com.cydeo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P12_LocateElementByXPATH {

    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://search.yahoo.com");

        WebElement searchBox = driver.findElement(By.xpath("//input[@class='sbq']"));
        searchBox.sendKeys("youtube");

        WebElement clearIcon = driver.findElement(By.xpath("//button[@id='sbq-clear']"));
        clearIcon.click();

        searchBox.sendKeys("twitch" + Keys.ENTER);

        Thread.sleep(3000);

        driver.quit();

    }
}
