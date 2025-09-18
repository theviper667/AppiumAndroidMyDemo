import com.codeborne.selenide.WebDriverRunner;
import core.AppiumServer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

import static core.AppiumDriverProvider.*;

public class BaseTest {
    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        AppiumServer.startServer();
        WebDriverRunner.setWebDriver(startAppiumDriver());
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
