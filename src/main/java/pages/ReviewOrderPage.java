package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import models.PaymentMethod;
import models.ShippingAddress;
import org.openqa.selenium.By;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.appium.AppiumSelectors.byClassNameAndIndex;
import static com.codeborne.selenide.appium.AppiumSelectors.byContentDescription;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class ReviewOrderPage extends BasePage{
    private SelenideAppiumElement getProductName() {
        return $(byContentDescription("product label"));
    }

    private SelenideAppiumElement getPlaceOrderButton() {
        return $(byContentDescription("Place Order button"));
    }

    private SelenideAppiumElement getDeliveryAddressSection() {
        return $(byContentDescription("checkout delivery address"));
    }

    private ElementsCollection getDeliveryFeeContainer() {
        return $$(byContentDescription("checkout delivery details"));
    }

    private SelenideElement getDeliveryFee() {
        return $(byContentDescription("checkout delivery details")).$(byClassNameAndIndex("android.widget.TextView", 2));
    }

    private SelenideAppiumElement getTotalAmount() {
        return $(byContentDescription("total price"));
    }

    private ElementsCollection getDeliveryAddressCollection() {
        return getDeliveryAddressSection().$$(AppiumBy.className("android.widget.TextView"));
    }

    private SelenideElement getDeliveryAddressLastLine() {
        return getDeliveryAddressSection().$(byClassNameAndIndex("android.widget.TextView", 4));
    }

    private SelenideAppiumElement getPaymentMethodSection() {
        return $(byContentDescription("checkout payment info"));
    }

    private ElementsCollection getPaymentMethodCollection() {
        return getPaymentMethodSection().$$(AppiumBy.className("android.widget.TextView"));
    }

    private SelenideElement getPaymentMethodSectionLastLine() {
        return getPaymentMethodSection().$(byClassNameAndIndex("android.widget.TextView", 3));
    }

    private SelenideAppiumElement getProductPrice(String itemName) {
        return $(By.xpath("//android.widget.TextView[@text=\""+itemName+"\"]/../android.widget.TextView[@content-desc=\"product price\"]"));
    }

    public String getProductNameText() {
        getProductName().scrollTo();
        return getTextFromElement(getProductName());
    }

    public String getProductPriceText(String productName) {
        getProductPrice(productName).scrollTo();
        return getTextFromElement(getProductPrice(productName));
    }

    public BigDecimal getProductPriceValue(String productName) {
        getProductPrice(productName).scrollTo();
        return extractCurrencyValue(getProductPrice(productName));
    }

    public CheckoutCompletePage clickPlaceOrderButton() {
        click(getPlaceOrderButton());
        return new CheckoutCompletePage();
    }

    public void verifyReviewDeliveryAddress(ShippingAddress shippingAddress) {
        getDeliveryAddressLastLine().scrollTo();
        getDeliveryAddressCollection().shouldHave(sizeGreaterThanOrEqual(4));
        getDeliveryAddressCollection().shouldHave(texts("Delivery Address",
                shippingAddress.getFullName(),
                shippingAddress.getAddressLine1(),
                shippingAddress.getCity(),
                shippingAddress.getCountry()+", "+shippingAddress.getZipCode()));
    }

    public void verifyReviewPaymentMethod(PaymentMethod paymentMethod) {
        getPaymentMethodCollection().shouldHave(sizeGreaterThan(3));
        getPaymentMethodSectionLastLine().scrollTo();
        getPaymentMethodCollection().shouldHave(texts("Payment Method",
                paymentMethod.getNameOnCard(),
                paymentMethod.getCardNumber(),
                "Exp: "+paymentMethod.getExpirationDate()));
    }

    public Map<String, BigDecimal> getCheckoutValues() {
        Map<String, BigDecimal> values = new HashMap<>();
        values.put("actualDeliveryFee", extractCurrencyValue(getDeliveryFee().scrollTo()));
        values.put("actualTotal", extractCurrencyValue(getTotalAmount().scrollTo()));
        return values;
    }
}
