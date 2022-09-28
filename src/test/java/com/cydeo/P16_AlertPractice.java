package com.cydeo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class P16_AlertPractice{

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

    }

    @Test
    public void jsAlertTest(){

        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

        WebElement jsAlertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsAlertButton.click();

        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(resultText.isDisplayed(),"Result text is not displayed");

    }

    @Test
    public void jsConfirmTest(){

        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

        WebElement jsConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsConfirm.click();

        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

        WebElement result = driver.findElement(By.id("result"));

        Assert.assertTrue(result.isDisplayed(),"Message is not displayed");

    }

    @Test
    public void jsPromptTest() throws InterruptedException{

        Thread.sleep(2000);

        WebElement jsPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPrompt.click();

        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        alert.accept();

        Thread.sleep(2000);

        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(result.isDisplayed(),"Message is not displayed");

    }

    @AfterMethod
    public void teardown(){

        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

        driver.quit();

    }

}
