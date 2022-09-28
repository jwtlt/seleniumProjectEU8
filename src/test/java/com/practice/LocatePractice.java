package com.practice;

import com.utility.Sleep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocatePractice {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://saucedemo.com");

        driver.manage().window().maximize();

        WebElement usernameBox = driver.findElement(By.id("user-name"));
        usernameBox.sendKeys("standard_user");

        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.submit();

        WebElement firstProductLink = driver.findElement(By.linkText("Sauce Labs Backpack"));
        System.out.println("ProductLink1 = " + firstProductLink.getAttribute("id"));

        WebElement firstProductLink2 = driver.findElement(By.id("item_4_title_link"));
        System.out.println("ProductLink2 = " + firstProductLink2.getText());

        List<WebElement> allProductTitle = driver.findElements(By.className("inventory_item_name"));

        System.out.println("allProductTitle = " + allProductTitle.size());

        for (int i = 1; i < allProductTitle.size(); i++) {
            System.out.println("Product " + i + " = " + allProductTitle.get(i).getText());
        }

        WebElement cartContainer = driver.findElement(By.id("shopping_cart_container"));
        cartContainer.click();

        Sleep.sleep(2);

        WebElement continueShopping = driver.findElement(By.id("continue-shopping"));
        continueShopping.click();

        Sleep.sleep(2);

        driver.quit();

    }
}
