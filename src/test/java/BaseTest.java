import com.codeborne.selenide.WebDriverRunner;
import core.AppiumServer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import pages.*;

import static core.AppiumDriverProvider.*;

public class BaseTest {

    protected InventoryPage inventoryPage;
    protected NavigationMenu navigationMenu;
    protected LoginPage loginPage;
    protected ProductPage productPage;
    protected CartPage cartPage;
    protected ReviewOrderPage reviewOrderPage;
    protected CheckoutCompletePage checkoutCompletePage;

    public BaseTest () {
        inventoryPage = new InventoryPage();
        navigationMenu = new NavigationMenu();
        loginPage = new LoginPage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        reviewOrderPage = new ReviewOrderPage();
        checkoutCompletePage = new CheckoutCompletePage();
    }

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        AppiumServer.startServer();
        WebDriverRunner.setWebDriver(startAppiumDriver());
    }

    public void testUserAutoFillLogin() {
        navigationMenu.openLogInPage();
        if(loginPage.testLoginAutofillExists()) {
            loginPage.useLoginAutofill();
        }
    }

    public void verifyLoggedOutUser() {
        navigationMenu.logOutSuccessfully();
        navigationMenu.clickPopUpOKButton();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver!=null) {
            driver.quit();
        }
        AppiumServer.stopServer();
        closeVirtualDevice();
    }
}
