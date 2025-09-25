package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.interactable;
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

    public static SelenideAppiumElement getPopupResetAppButton() {
        return $(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\" and @text=\"RESET APP\"]"));
    }

    private SelenideAppiumElement getLoggedOutPopUpTitle() {
        return $(By.xpath("//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]"));
    }

    public static SelenideAppiumElement getBurgerMenuResetAppItem() {
        return $(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item reset app\"]"));
    }

    public SelenideElement getBurgerMenuCatalogItem() {
        return $(AppiumBy.androidUIAutomator("new UiScrollable("+getBurgerMenuContainerText()+
                ").scrollIntoView(new UiSelector().text(\"Catalog\"))"));
    }

    public String getBurgerMenuContainerText() {
        return "new UiSelector().className(\"android.widget.ScrollView\").instance(0)";
    }

    public SelenideElement getBurgerMenuContainer() {
        return $(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ScrollView\").instance(0)"));
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
        getBurgerMenuButton().shouldBe(interactable).click();
        waitForElement(getBurgerMenuContainer());
        waitForElement(getBurgerMenuCatalogItem());
        click(getBurgerMenuCatalogItem());
        return new InventoryPage();

    }

    public InventoryPage resetAppState() {
        click(getBurgerMenuButton());
        waitForElement(getBurgerMenuContainer());
        click(getBurgerMenuResetAppItem());
        click(getPopupResetAppButton());
        clickPopUpOKButton();
        waitForElement(getBurgerMenuCatalogItem());
        click(getBurgerMenuCatalogItem());
        return new InventoryPage();
    }
}
