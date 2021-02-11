package com.auto.knowcross.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDashboard {

    WebDriver driver;

    @FindBy(name="keyword")
    WebElement search;

    @FindBy(name="searchProducts")
    WebElement searchProduct;

    @FindBy(xpath="//*[contains(text(),'K9-CW-01')]")
    WebElement productId;

    @FindBy(xpath="//tbody/tr[3]//*[contains(text(),'Add to Cart')]")
    WebElement addToCart;

    @FindBy(xpath="//*[contains(text(),'Proceed to Checkout')]")
    WebElement proceedToCheckout;

    @FindBy(name="newOrder")
    WebElement newOrder;

    @FindBy(linkText="Confirm")
    WebElement confirm;

    @FindBy(linkText="Sign Out")
    WebElement logout;

    public UserDashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String productName){
        search.sendKeys(productName);
    }
    public void clickOnSerachButton(){
        searchProduct.click();
    }
    public void clickOnProductLink(){
        productId.click();
    }
    public void clickOnAddToCartButton(){
        addToCart.click();
    }
    public void clickOnProceedToCheckoutButton(){
        proceedToCheckout.click();
    }
    public void clickOnContinueButton(){
        newOrder.click();
    }

    public void clickOnConfirmButton(){
        confirm.click();
    }

    public HomePage clickOnLogoutButton(){
        logout.click();
        return new HomePage(driver);
    }
}
