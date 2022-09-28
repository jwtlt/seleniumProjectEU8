package com.cydeo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class P15_DropdownAndMultipleDropdown {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");

        driver.manage().window().maximize();

        WebElement dropdownList = driver.findElement(By.xpath("//select[@id='dropdown']"));

        Select selectObject = new Select(dropdownList);
        selectObject.selectByIndex(1);

        //selectObject.selectByVisibleText("Option 1");

        WebElement year = driver.findElement(By.cssSelector("select[id='year']"));

        Select selectYear = new Select(year);
        selectYear.selectByVisibleText("1993");

        WebElement month = driver.findElement(By.xpath("//*[@id=\"month\"]/option[10]"));
        month.click();

        WebElement day = driver.findElement(By.id("day"));

        Select selectDay = new Select(day);
        selectDay.selectByValue("16");

        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));

        Select selectState = new Select(state);
        selectState.selectByVisibleText("New York");

        System.out.println("-------------------------------------------------------");

        WebElement multiItemDropdown = driver.findElement(By.name("Languages"));

        Select selectMultiItem = new Select(multiItemDropdown);

        selectMultiItem.selectByVisibleText("Java");
        selectMultiItem.selectByIndex(1);
        selectMultiItem.selectByValue("python");
        selectMultiItem.selectByVisibleText("C#");

        selectMultiItem.deselectByIndex(2);
        selectMultiItem.deselectByVisibleText("Python");
        selectMultiItem.deselectByValue("js");

        System.out.println("--------------------------------------------------------");

        //Dropdown without a select tag
        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown link"));
        dropdownLink.click();

        WebElement googleLink = driver.findElement(By.linkText("Google"));
        googleLink.click();

        driver.quit();

    }
}
