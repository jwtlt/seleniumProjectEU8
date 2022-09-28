package com.practice;

import com.utility.Driver;
import com.utility.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutor {

    @Test
    public void jsExecute(){

        WebDriver driver = Driver.getDriver();

        driver.get("https://www.youtube.com/");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1500)");
        Sleep.sleep(2);
        jse.executeScript("window.scrollBy(0,1250)");
        Sleep.sleep(2);
        jse.executeScript("window.scrollBy(0,-1750)");

        WebElement icon = driver.findElement(By.xpath("//*[@id=\"logo-icon\"]"));
        jse.executeScript("arguments[0].scrollIntoView(true)",icon);

        jse.executeScript("window.open('https://www.google.com.tr/','_blank')");

    }
}
