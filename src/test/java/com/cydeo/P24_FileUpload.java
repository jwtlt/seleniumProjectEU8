package com.cydeo;

import com.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class P24_FileUpload {

    @Test
    public void testFileUpload(){

        WebDriver driver = Driver.getDriver();

        driver.get("http://practice.cybertekschool.com/upload");

        String filePath = "C:\\Users\\Yeni\\Desktop\\wp3208018.jpg";
        driver.findElement(By.id("file-upload")).sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click();

        Driver.closeBrowser();

    }

}
