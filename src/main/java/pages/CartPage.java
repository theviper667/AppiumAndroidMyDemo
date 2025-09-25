package pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.appium.AppiumSelectors.byContentDescription;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class CartPage extends BasePage{
    private SelenideAppiumElement getProductName() {
        return $(byContentDescription("product label"));
    }

    private SelenideAppiumElement getProductCounterContainer(String itemName) {
        return $(By.xpath("//android.widget.TextView[@text=\""+itemName+"\"]/../android.view.ViewGroup[@content-desc=\"counter amount\"]"));
    }

    private SelenideAppiumElement getProductPrice(String itemName) {
        return $(By.xpath("//android.widget.TextView[@text=\""+itemName+"\"]/../android.widget.TextView[@content-desc=\"product price\"]"));
    }

    private SelenideAppiumElement getProceedToCheckoutButton() {
        return $(byContentDescription("Proceed To Checkout button"));
    }

    public String getProductNameText() {
        return getTextFromElement(getProductName());
    }

    public String getProductCounterText(String itemName) {
        return getTextFromParentContainers(getProductCounterContainer(itemName));
    }

    public String getProductPriceText(String itemName) {
        return getTextFromElement(getProductPrice(itemName));
    }

    public ShippingAddressPage clickCheckoutButton() {
        click(getProceedToCheckoutButton());
        return new ShippingAddressPage();
    }
}
