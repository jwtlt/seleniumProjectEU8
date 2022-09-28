package com.cydeo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P17_Iframe {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/iframe");

    }

    @Test
    public void iframeTest(){

        //driver.switchTo().frame("mce_0_ifr");

        driver.switchTo().frame(0);

        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));

        WebElement text = driver.findElement(By.xpath("//p"));

        Assert.assertTrue(text.isDisplayed());

        driver.switchTo().parentFrame();

        WebElement headerText = driver.findElement(By.xpath("//h3"));

        Assert.assertTrue(headerText.isDisplayed());

    }

    @AfterMethod
    public void teardown(){

        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

        driver.quit();

    }

}
