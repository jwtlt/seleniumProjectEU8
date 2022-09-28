package com.practice;


import com.utility.TestBase;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ForgetPasswordPageTest extends TestBase {

    @Test
    public void testForgetPassport(){

        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.findElement(By.name("email")).sendKeys("a@a.com"+ Keys.ENTER);
        String currentURL = driver.getCurrentUrl() ;
        // assertion
        assertTrue(currentURL.endsWith("email_sent")) ;

    }

}
