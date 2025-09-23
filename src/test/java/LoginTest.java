import data.LoginData;
import data.TestDataProvider;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @BeforeSuite
    public void setLoggedOutApp() {
        verifyLoggedOutUser();
    }

    @Test (dataProvider = "validLoginData", dataProviderClass = TestDataProvider.class)
    @Description("Verify a user with valid login details can login and is redirected to the homepage")
    public void verifyValidLogin(LoginData loginData) {
        navigationMenu.openLogInPage()
                .enterValidLogin(loginData.getUsername(), loginData.getPassword());
        Assert.assertTrue(inventoryPage.isProductScreenVisible(), "Product catalog page was not opened");
    }

    @Test
    @Description("Verify a user that a logged in user can logout successfully")
    public void verifyLogout() {
        testUserAutoFillLogin();
        navigationMenu.logOutSuccessfully();
        Assert.assertEquals(navigationMenu.getLoggedOutPopUpTitleText(), "You are successfully logged out.");
        navigationMenu.clickPopUpOKButton();
    }

    @Test (dataProvider = "invalidLoginData", dataProviderClass = TestDataProvider.class)
    @Description("Verify the various login errors are displayed for their respective scenarios")
    public void verifyInvalidCredentialsError(LoginData invalidLoginData) {
        navigationMenu.openLogInPage()
                .enterInvalidLogin(invalidLoginData.getUsername(), invalidLoginData.getPassword());
        Assert.assertTrue(loginPage.isLoginErrorVisible(invalidLoginData.getErrormessage()), "Error message: "
        +invalidLoginData.getErrormessage()+ "was not shown");
    }
}
