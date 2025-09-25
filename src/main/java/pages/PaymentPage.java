package pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import models.PaymentMethod;

import static com.codeborne.selenide.appium.AppiumSelectors.byContentDescription;
import static com.codeborne.selenide.appium.SelenideAppium.$;

public class PaymentPage extends BasePage{
    public SelenideAppiumElement getFullNameTextField() {
        return $(byContentDescription("Full Name* input field"));
    }

    public SelenideAppiumElement getCardNumberTextField() {
        return $(byContentDescription("Card Number* input field"));
    }

    public SelenideAppiumElement getExpirationDateTextField() {
        return $(byContentDescription("Expiration Date* input field"));
    }

    public SelenideAppiumElement getSecurityCodeTextField() {
        return $(byContentDescription("Security Code* input field"));
    }

    public SelenideAppiumElement getReviewOrderButton() {
        return $(byContentDescription("Review Order button"));
    }

    public ReviewOrderPage fillPaymentMethod(PaymentMethod paymentMethod) {
        waitForElement(getFullNameTextField());
        type(getFullNameTextField(), paymentMethod.getNameOnCard());
        type(getCardNumberTextField().scrollTo(), paymentMethod.getCardNumber());
        type(getExpirationDateTextField().scrollTo(), paymentMethod.getExpirationDate());
        type(getSecurityCodeTextField().scrollTo(), paymentMethod.getCvv());
        click(getReviewOrderButton().scrollTo());
        return new ReviewOrderPage();
    }
}
