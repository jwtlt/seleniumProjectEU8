package com.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElementByCssSelectorPractice {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/registration_form");

        driver.manage().window().maximize();

        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstName.sendKeys("Sinan");

        WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastName.sendKeys("Bozkurt");

        WebElement username = driver.findElement(By.cssSelector("input[type=\"text\"][placeholder=\"username\"]"));
        username.sendKeys("jwtlt37");

        WebElement email = driver.findElement(By.cssSelector("input.form-control[placeholder^='email']"));
        email.sendKeys("sinanbozkurt37@gmail.com");

        WebElement password = driver.findElement(By.cssSelector("input[class|='form'][type='password']"));
        password.sendKeys("sinanbozkurt37");

        WebElement phoneNumber = driver.findElement(By.cssSelector("input[class|='form'][type$='l']"));
        phoneNumber.sendKeys("542-199-3734");

        WebElement gender = driver.findElement(By.cssSelector(".col-sm-5>.radio>label>input[value='male']"));
        gender.click();

        WebElement dateOfBirth = driver.findElement(By.cssSelector("input[placeholder^='MM']"));
        dateOfBirth.sendKeys("10/16/1993");

        WebElement department = driver.findElement(By.cssSelector("option[value~='DE']"));
        department.click();

        WebElement job = driver.findElement(By.cssSelector("div:nth-child(10) > div > select > option:nth-child(5)"));
        job.click();

        WebElement language = driver.findElement(By.cssSelector("input[value='java']"));
        language.click();

        WebElement signUpButton = driver.findElement(By.cssSelector("#wooden_spoon"));
        signUpButton.click();

    }
}
