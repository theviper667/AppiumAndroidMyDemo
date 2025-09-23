package pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class NavigationMenu extends BasePage{
    public static SelenideAppiumElement getBurgerMenuButton() {
        return $(By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]"));
    }

    public static SelenideAppiumElement getBurgerMenuLogInItem() {
        return $(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item log in\"]"));
    }

    public static SelenideAppiumElement getBurgerMenuLogOutItem() {
        return $(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item log out\"]"));
    }

    public static SelenideAppiumElement getPopupLogOutButton() {
        return $(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\" and @text=\"LOG OUT\"]"));
    }

    public static SelenideAppiumElement getPopupOKButton() {
        return $(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\" and @text=\"OK\"]"));
    }

    private SelenideAppiumElement getLoggedOutPopUpTitle() {
        return $(By.xpath("//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]"));
    }

    public static SelenideAppiumElement getBurgerMenuResetAppItem() {
        return $(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item reset app\"]"));
    }

    public static SelenideAppiumElement getBurgerMenuCatalogItem() {
        return $(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item catalog\"]"));
    }

    public static SelenideAppiumElement getBurgerMenuContainer() {
        return $(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item reset app\"]/../.."));
    }

    public LoginPage openLogInPage () {
        click(getBurgerMenuButton());
        click(getBurgerMenuLogInItem());
        return new LoginPage();
    }

    public LoginPage logOutSuccessfully() {
        click(getBurgerMenuButton());
        click(getBurgerMenuLogOutItem());
        click(getPopupLogOutButton());
        return new LoginPage();
    }

    public String getLoggedOutPopUpTitleText() {
        return getTextFromElement(getLoggedOutPopUpTitle());
    }

    public LoginPage clickPopUpOKButton() {
        click(getPopupOKButton());
        return new LoginPage();
    }

    public InventoryPage returnToCatalog() {
        click(getBurgerMenuButton());
        getBurgerMenuContainer().scrollTo();
        click(getBurgerMenuCatalogItem());
        return new InventoryPage();
    }
}
