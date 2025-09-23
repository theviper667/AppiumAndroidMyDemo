package pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.appium.AppiumSelectors.byText;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class InventoryPage extends BasePage{

    private SelenideAppiumElement getProductsScreen() {
        return $(By.xpath("//android.view.ViewGroup[@content-desc=\"products screen\"]"));
    }

    private SelenideAppiumElement getProductTitle(String itemName) {
        return $(byText(itemName));
    }

    private SelenideAppiumElement getProductContainer(String itemName) {
        return $(By.xpath("//android.widget.TextView[@text=\""+itemName+"\"]/../.."));
    }

    private SelenideAppiumElement getProductPrice(String itemName) {
        return $(By.xpath("//android.widget.TextView[@text=\""+itemName+
                "\"]/../../android.widget.TextView[@content-desc=\"store item price\"]"));
    }

    public boolean isProductNameVisible(String itemName) {
        return isElementVisible(getProductTitle(itemName).scrollTo());
    }

    public ProductPage clickProductName(String itemName) {
        click(getProductTitle(itemName));
        return new ProductPage();
    }

    public boolean isProductScreenVisible() {
        return isElementVisible(getProductsScreen());
    }

    public String getProductPriceText(String itemName) {
        return getTextFromElement(getProductPrice(itemName).scrollTo());
    }
}
