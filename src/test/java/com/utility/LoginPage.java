package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement usernameBox ;

    @FindBy(name = "ctl00$MainContent$password")
    public WebElement passwordBox ;

    @FindBy(xpath = "//input[@value='Login']")
    public WebElement loginButton ;

    @FindBy(css = "div>p>span")
    public WebElement errMsg ;

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void goTo(){
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2ftestcomplete12%2fweborders%2fProcess.aspx");
    }

    public void login(String username, String password){

        this.usernameBox.sendKeys(username);
        this.passwordBox.sendKeys(password);
        this.loginButton.click();

    }

    public boolean isLoginErrorMsgDisplayed(){
        return errMsg.isDisplayed();
    }

    public boolean isAt(){
        return Driver.getDriver().getTitle().equals("Web Orders Login");
    }

}
