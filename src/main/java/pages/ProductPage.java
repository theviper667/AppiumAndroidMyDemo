package pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import static com.codeborne.selenide.appium.AppiumSelectors.*;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class ProductPage extends BasePage{
    private SelenideAppiumElement getProductTitle() {
        return $(byContentDescription("container header"));
    }

    private SelenideAppiumElement getProductPrice() {
        return $(byContentDescription("product price"));
    }

    private SelenideAppiumElement getAddToCartButton() {
        return $(byContentDescription("Add To Cart button"));
    }

    private SelenideAppiumElement getProductDescription() {
        return $(byContentDescription("product description"));
    }

    private SelenideAppiumElement getCartBadge() {
        return $(byContentDescription("cart badge"));
    }

    private SelenideAppiumElement getAddToCartCounter() {
        return $(byContentDescription("counter amount"));
    }

    public String getProductPriceText() {
        return getTextFromElement(getProductPrice().scrollTo());
    }

    public String getCartItemsCount() {
        return getTextFromParentContainers(getCartBadge());
    }

    public String getAddToCartCount() {
        return getTextFromParentContainers(getAddToCartCounter());
    }

    public String getProductTitleText() {
        waitForElement(getProductTitle());
        getProductTitle().scrollTo();
        return getTextFromParentContainers(getProductTitle());
    }

    public String getProductDescriptionText() {
        return getTextFromElement(getProductDescription().scrollTo());
    }

    public void clickAddToCartButton() {
        click(getAddToCartButton().scrollTo());
    }

    public CartPage clickCartBadge() {
        click(getCartBadge());
        return new CartPage();
    }
}
