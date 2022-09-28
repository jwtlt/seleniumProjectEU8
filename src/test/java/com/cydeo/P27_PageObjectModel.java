package com.cydeo;

import com.utility.LoginPage;
import com.utility.Sleep;
import org.testng.annotations.Test;

public class P27_PageObjectModel {

    @Test
    public void login(){

        LoginPage loginPage = new LoginPage();
        loginPage.goTo();
        loginPage.isAt();

        loginPage.login("Tester", "Test");

        Sleep.sleep(3);

    }

}
