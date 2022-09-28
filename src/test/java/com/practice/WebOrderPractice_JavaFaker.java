package com.practice;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import com.utility.ConfigReader;
import com.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WebOrderPractice_JavaFaker {

    @Test
    public void webOrder(){

        Faker faker = new Faker();

        WebDriver driver = Driver.getDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?");

        WebElement username = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$login_button']"));

        username.sendKeys("Tester");
        password.sendKeys("test");
        loginButton.click();

        WebElement orderButton = driver.findElement(By.xpath("//li[3]/a"));

        orderButton.click();

        WebElement screenSaver = driver.findElement(By.xpath("//option[3]"));
        screenSaver.click();

        WebElement quantity = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']"));
        quantity.sendKeys(faker.numerify("###"));

        WebElement name = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
        name.sendKeys(faker.address().firstName());

        WebElement street = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
        street.sendKeys(faker.address().streetAddress());

        WebElement city = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']"));
        city.sendKeys(faker.address().cityName());

        WebElement state = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4']"));
        state.sendKeys(faker.address().state());

        WebElement zip = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']"));
        zip.sendKeys(faker.address().zipCode());

        WebElement card = driver.findElement(By.xpath("//tr/td[3]"));
        card.click();

        WebElement cardNumber = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']"));
        cardNumber.sendKeys(faker.numerify("################"));

        WebElement expireDate = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']"));
        expireDate.sendKeys(faker.numerify("##/##"));

    }
}
