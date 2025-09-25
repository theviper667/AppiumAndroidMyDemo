package pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import models.ShippingAddress;

import static com.codeborne.selenide.appium.AppiumSelectors.byContentDescription;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class ShippingAddressPage extends BasePage{
    public SelenideAppiumElement getFullNameTextField() {
        return $(byContentDescription("Full Name* input field"));
    }

    public SelenideAppiumElement getAddressLine1TextField() {
        return $(byContentDescription("Address Line 1* input field"));
    }

    public SelenideAppiumElement getCityTextField() {
        return $(byContentDescription("City* input field"));
    }

    public SelenideAppiumElement getZipCodeTextField() {
        return $(byContentDescription("Zip Code* input field"));
    }

    public SelenideAppiumElement getCountryTextField() {
        return $(byContentDescription("Country* input field"));
    }

    public SelenideAppiumElement getToPaymentButton() {
        return $(byContentDescription("To Payment button"));
    }

    public PaymentPage fillShippingAddress (ShippingAddress shippingAddress) {
        waitForElement(getFullNameTextField());
        type(getFullNameTextField(), shippingAddress.getFullName());
        type(getAddressLine1TextField().scrollTo(), shippingAddress.getAddressLine1());
        type(getZipCodeTextField().scrollTo(), shippingAddress.getZipCode());
        type(getCityTextField().scrollTo(), shippingAddress.getCity());
        type(getCountryTextField().scrollTo(), shippingAddress.getCountry());
        click(getToPaymentButton().scrollTo());
        return new PaymentPage();
    }
}
