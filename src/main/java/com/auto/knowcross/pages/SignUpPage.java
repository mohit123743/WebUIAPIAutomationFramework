package com.auto.knowcross.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {

    WebDriver driver;

    @FindBy(name="username")
    WebElement userID;

    @FindBy(name="password")
    WebElement password;

    @FindBy(name="repeatedPassword")
    WebElement repeatedPassword;

    @FindBy(name="account.firstName")
    WebElement firstName;

    @FindBy(name="account.lastName")
    WebElement lastName;

    @FindBy(name="account.email")
    WebElement email;

    @FindBy(name="account.phone")
    WebElement phoneNumber;

    @FindBy(name="account.address1")
    WebElement addressLine1;

    @FindBy(name="account.address2")
    WebElement addressLine2;

    @FindBy(name="account.city")
    WebElement city;

    @FindBy(name="account.state")
    WebElement state;

    @FindBy(name="account.zip")
    WebElement zip;

    @FindBy(name="account.country")
    WebElement country;

    @FindBy(name="account.favouriteCategoryId")
        WebElement favouriteCategory;

    @FindBy(name="account.listOption")
    WebElement enableMyList;

    @FindBy(name="account.bannerOption")
    WebElement enableMyBanner;

    @FindBy(name="newAccount")
    WebElement newAccount;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUserName(String uname) {
        userID.sendKeys(uname);
    }

    public void enterPassword(String pwd) {
        password.sendKeys(pwd);
    }

    public void enterRepeatedPassword(String repeatedPwd) {
        repeatedPassword.sendKeys(repeatedPwd);
    }

    public void enterFirstName(String fname) {
        firstName.sendKeys(fname);
    }

    public void enterLastName(String lname) {
        lastName.sendKeys(lname);
    }

    public void enterEmail(String emailid) {
        email.sendKeys(emailid);
    }

    public void enterPhoneNumber(String mobileNumber) {
        phoneNumber.sendKeys(mobileNumber);
    }

    public void enterAddressline1(String addLine1) {
        addressLine1.sendKeys(addLine1);
    }

    public void enterAddressLine2(String addLine2) { addressLine2.sendKeys(addLine2); }

    public void enterCity(String cityname) {
        city.sendKeys(cityname);
    }

    public void enterState(String statename) {
        state.sendKeys(statename);
    }

    public void enterCountry(String countryname) {
        country.sendKeys(countryname);
    }

    public void enterZip(String zipcode) {
        zip.sendKeys(zipcode);
    }

    public Select getSelectOptions() {
        return new Select(favouriteCategory);
    }

    public void selectFavouriteCategory(String catagory) {

        getSelectOptions().selectByValue(catagory);
    }

    public void clickEnableMyList() { enableMyList.click(); }

    public void clickEnableMyBanner() {
        enableMyBanner.click();
    }

    public HomePage clickSaveAccountInformationButton() {
        newAccount.click();
        return new HomePage(driver);
    }




}
