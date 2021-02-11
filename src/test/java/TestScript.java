import com.auto.knowcross.base.TestBase;
import com.auto.knowcross.pages.HomePage;
import com.auto.knowcross.pages.SignInPage;
import com.auto.knowcross.pages.SignUpPage;
import com.auto.knowcross.pages.UserDashboard;
import com.auto.knowcross.util.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

public class TestScript extends TestBase {

    HomePage homePage;
    SignInPage signInPage;
    SignUpPage signUpPage;
    UserDashboard userDashboard;

    Random rand = new Random();
    String rand_userId = "test"+String.valueOf(rand.nextInt(1000));
    String password = "password";




    public void loginTest() {


        homePage = new HomePage(driver);
        signInPage = homePage.clicksignInLink();
        signInPage.enterUsername(rand_userId);
        signInPage.enterPassword("password");
        signInPage.clickLoginButton();
        String title = signInPage.getTitle();
        Assert.assertEquals("JPetStore Demo",title);


    }

    @DataProvider(name = "tempTestData")
    public Object[][] tempTestData() throws Exception {

        String[][] testData = ExcelUtil.getExcelDataIn2DArray(System.getProperty("user.dir") + "//src//test//TestData//TestData.xlsx", "testDataSheet");
        return testData;
    }

     @Test(dataProvider = "tempTestData")
    public void createUserTest(String firstname, String lastname, String email, String mobilenumber,String addressline1, String addressline2, String city, String state, String zip, String country, String  catagory ){

     homePage = new HomePage(driver);
     signInPage = homePage.clicksignInLink();
     signUpPage = signInPage.clickSignupButton();

     // User Information
     signUpPage.enterUserName(rand_userId);
     signUpPage.enterPassword(password);
     signUpPage.enterRepeatedPassword(password);

     // Account Information
     signUpPage.enterFirstName(firstname);
     signUpPage.enterLastName(lastname);
     signUpPage.enterEmail(email);
     signUpPage.enterPhoneNumber(mobilenumber);
     signUpPage.enterAddressline1(addressline1);
     signUpPage.enterAddressLine2(addressline2);
     signUpPage.enterCity(city);
     signUpPage.enterState(state);
     signUpPage.enterZip(zip);
     signUpPage.enterCountry(country);

     // Profile Information
     signUpPage.selectFavouriteCategory(catagory);
     signUpPage.clickEnableMyList();
     signUpPage.clickEnableMyBanner();

     // Click on Save Account Information
     signUpPage.clickSaveAccountInformationButton();
     }


    @Test
    public void searchFavCatagoryTest() {
        loginTest();
        userDashboard = new UserDashboard(driver);
        userDashboard.searchProduct("Chihuahua");
        userDashboard.clickOnSerachButton();
        userDashboard.clickOnProductLink();
        userDashboard.clickOnAddToCartButton();
        userDashboard.clickOnProceedToCheckoutButton();
        userDashboard.clickOnContinueButton();
        userDashboard.clickOnConfirmButton();
        homePage= userDashboard.clickOnLogoutButton();
        signInPage = homePage.clicksignInLink();
        signInPage.enterUsername(rand_userId);
        signInPage.enterPassword(password);
        signInPage.clickLoginButton();

    }
}
