package com.auto.knowcross.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class SignInPage {

    WebDriver driver;

   // private static final Logger log = LogManager.getLogger(SauceDemoLoginPage.class);

    @FindBy(name="username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath="//input[@name='signon']")
    WebElement loginButton;

    @FindBy(linkText="Register Now!")
    WebElement signUp;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void enterUsername(String uname) {
        username.sendKeys(uname);
    }

    public void enterPassword(String pwd) {

        password.clear();
        password.sendKeys(pwd);
    }

    public UserDashboard clickLoginButton() {
        loginButton.click();
        return new UserDashboard(driver);
    }

    public SignUpPage clickSignupButton() {
        signUp.click();
        return new SignUpPage(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
