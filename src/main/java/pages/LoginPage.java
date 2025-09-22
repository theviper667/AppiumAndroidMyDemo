package pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class LoginPage extends BasePage{

    public SelenideAppiumElement getUserNameTextField() {
        return $(By.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]"));
    }

    public SelenideAppiumElement getPasswordTextField() {
        return $(By.xpath("//android.widget.EditText[@content-desc=\"Password input field\"]"));
    }

    private SelenideAppiumElement getLoginButton() {
        return $(By.xpath("//android.view.ViewGroup[@content-desc=\"Login button\"]"));
    }

    private SelenideAppiumElement getLoginErrorMessage(String error) {
        return $(By.xpath("//android.widget.TextView[@text=\""+error+"\"]"));
    }

    private SelenideAppiumElement getTestLoginAutoFill() {
        return $(By.xpath("//android.view.ViewGroup[@content-desc=\"bob@example.com-autofill\"]"));
    }

    public LoginPage enterInvalidLogin (String username, String password) {
        type(getUserNameTextField(), username);
        type(getPasswordTextField(), password);
        click(getLoginButton());
        return this;
    }

    public InventoryPage enterValidLogin (String username, String password) {
        type(getUserNameTextField(), username);
        type(getPasswordTextField(), password);
        click(getLoginButton());
        return new InventoryPage();
    }

    public boolean isLoginErrorVisible(String alert) {
        return isElementVisible(getLoginErrorMessage(alert));
    }

    public boolean testLoginAutofillExists() {
        return getTestLoginAutoFill().scrollTo().exists();
    }

    public void useLoginAutofill() {
        click(getTestLoginAutoFill().swipeTo());
        click(getLoginButton().swipeTo());
    }
}
