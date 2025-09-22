import com.codeborne.selenide.WebDriverRunner;
import core.AppiumServer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import pages.InventoryPage;
import pages.LoginPage;
import pages.NavigationMenu;

import static core.AppiumDriverProvider.*;

public class BaseTest {

    protected InventoryPage inventoryPage;
    protected NavigationMenu navigationMenu;
    protected LoginPage loginPage;

    public BaseTest () {
        inventoryPage = new InventoryPage();
        navigationMenu = new NavigationMenu();
        loginPage = new LoginPage();
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
