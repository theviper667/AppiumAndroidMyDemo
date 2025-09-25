package pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import static com.codeborne.selenide.appium.AppiumSelectors.byContentDescription;
import static com.codeborne.selenide.appium.AppiumSelectors.byText;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class CheckoutCompletePage extends BasePage{
    private SelenideAppiumElement getContinueShoppingButton() {
        return $(byContentDescription("Continue Shopping button"));
    }

    private SelenideAppiumElement getCheckoutCompleteContainer() {
        return $(byContentDescription("checkout complete screen"));
    }

    private SelenideAppiumElement getCheckoutCompleteHeader() {
        return $(byText("Checkout Complete"));
    }

    public boolean getCheckoutCompleteHeaderVisibility() {
        waitForElement(getCheckoutCompleteContainer());
        return isElementVisible(getCheckoutCompleteHeader());
    }

    public InventoryPage clickContinueShoppingButton() {
        click(getContinueShoppingButton());
        return new InventoryPage();
    }
}
