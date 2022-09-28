package com.cydeo;

import com.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class P21_JavaScriptExecutor extends TestBase {

    @Test
    public void test_Scroll() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        Thread.sleep(2000);
        // Get JavaScriptExecutor reference from driver variable
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,1000)");

        for (int i = 0; i < 10; i++) {

            jse.executeScript("window.scrollBy(0,1000)");
            Thread.sleep(1000);

        }

        Thread.sleep(3000);
    }

    @Test
    public void test_ScrollElementInto_the_View() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/large");
        Thread.sleep(2000);

        WebElement schoolLnk = driver.findElement(By.xpath("//a[@target]"));
        WebElement homeLnk = driver.findElement(By.linkText("Home"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)" , schoolLnk);
        Thread.sleep(1000);

        jse.executeScript("arguments[0].scrollIntoView(true)",  homeLnk  ) ;
        Thread.sleep(2000);

        jse.executeScript("alert('whats up?')"  ) ;
        Thread.sleep(4000);

    }

    @Test
    public void test_OpenNewTab_withURL() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com");
        Thread.sleep(2000);

        // get JavascriptExecutor reference
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("window.open('https://google.com','_blank')");
        Thread.sleep(2000);

        jse.executeScript("window.open('https://cybertekschool.com','_blank')");
        Thread.sleep(2000);

        jse.executeScript("window.open('https://search.yahoo.com','_blank')");
        Thread.sleep(2000);

        for(String each : driver.getWindowHandles()){

            driver.switchTo().window(each);
            System.out.println("Current title after switching windows = " + driver.getTitle());

        }

        // get all windows handles and print it out
        // switch to each window and print the title


    }

}
