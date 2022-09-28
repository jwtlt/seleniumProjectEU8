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

public class P18_WindowHandle {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/windows");

    }

    @Test
    public void multipleWindowTest(){

        String mainPage = driver.getWindowHandle();

        System.out.println("mainPage = " + mainPage);

        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();

        System.out.println("Title before click = " + actualTitle);

        Assert.assertEquals(expectedTitle,actualTitle);

        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        for(String each : driver.getWindowHandles()){

            driver.switchTo().window(each);
            System.out.println("Current title after switching windows = " + driver.getTitle());

        }

        String expectedTitleAfterClick = "New Window";

        Assert.assertEquals(driver.getTitle(),expectedTitleAfterClick);

    }

    @AfterMethod
    public void teardown(){

        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

        driver.quit();

    }

}
