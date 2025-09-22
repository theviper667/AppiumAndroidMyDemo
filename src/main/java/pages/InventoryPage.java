package pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class InventoryPage extends BasePage{

    private SelenideAppiumElement getProductsScreen() {
        return $(By.xpath("//android.view.ViewGroup[@content-desc=\"products screen\"]"));
    }

    public boolean isProductScreenVisible() {
        return isElementVisible(getProductsScreen());
    }
}
