import data.LoginData;
import data.TestDataProvider;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @BeforeSuite
    public void setLoggedOutApp() {
        Allure.step("Before the test we make sure no user is logged in");
        verifyLoggedOutUser();
    }

    @Test (dataProvider = "validLoginData", dataProviderClass = TestDataProvider.class)
    @Description("Verify a user with valid login details can login and is redirected to the homepage")
    public void verifyValidLogin(LoginData loginData) {
        Allure.step("Login by entering the credentials username "+loginData.getUsername()+" and password "+loginData.getPassword());
        navigationMenu.openLogInPage()
                .enterValidLogin(loginData.getUsername(), loginData.getPassword());
        Allure.step("Verify the user is placed on the catalog page");
        Assert.assertTrue(inventoryPage.isProductScreenVisible(), "Product catalog page was not opened");
    }

    @Test
    @Description("Verify a user that a logged in user can logout successfully")
    public void verifyLogout() {
        Allure.step("Utilize the default test login provided by the app");
        testUserAutoFillLogin();
        Allure.step("Perform the actions to logout");
        navigationMenu.logOutSuccessfully();
        Allure.step("Validate the successful logout popup is shown and close the popup");
        Assert.assertEquals(navigationMenu.getLoggedOutPopUpTitleText(), "You are successfully logged out.");
        navigationMenu.clickPopUpOKButton();
    }

    @Test (dataProvider = "invalidLoginData", dataProviderClass = TestDataProvider.class)
    @Description("Verify the various login errors are displayed for their respective scenarios")
    public void verifyInvalidCredentialsError(LoginData invalidLoginData) {
        Allure.step("Login by entering the credentials username "+invalidLoginData.getUsername()+" and password "+invalidLoginData.getPassword());
        navigationMenu.openLogInPage()
                .enterInvalidLogin(invalidLoginData.getUsername(), invalidLoginData.getPassword());
        Allure.step("Verify the error message displays: "+invalidLoginData.getErrormessage());
        Assert.assertTrue(loginPage.isLoginErrorVisible(invalidLoginData.getErrormessage()), "Error message: "
        +invalidLoginData.getErrormessage()+ "was not shown");
    }
}
