package com.cydeo;

import com.utility.Driver;
import com.utility.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class P26_Synchronization_ExplicitWait {

    @Test
    public void waitForTitle(){

        WebDriver driver = Driver.getDriver();
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        driver.findElement(By.partialLinkText("Example 7:")).click();

        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        WebElement message = driver.findElement(By.id("alert"));
        assertTrue(message.isDisplayed());

    }

    @Test
    public void waitUntilClickable(){

        WebDriver driver = Driver.getDriver();

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));
        driver.findElement(By.xpath("//form[2]/button")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));

        inputBox.sendKeys("hello");

        Sleep.sleep(2);

        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's enabled!"));

        Sleep.sleep(2);

        driver.close();
    }

    @Test
    public void waitUntilVisible(){

        WebDriver driver = Driver.getDriver();

        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        driver.findElement(By.partialLinkText("Example 1:")).click();

        driver.findElement(By.cssSelector("#start>button")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish>h4")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));

        driver.findElement(By.id("username")).sendKeys("Wait Successfully");

        Sleep.sleep(2);

        driver.close();

    }

}
