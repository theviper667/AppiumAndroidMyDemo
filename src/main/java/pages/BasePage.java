package pages;

import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static core.AppiumDriverProvider.driver;

public class BasePage {

    protected void click(SelenideAppiumElement element) {
        element.shouldBe((visible), Duration.ofSeconds(15)).click();
    }

    protected void type(SelenideAppiumElement element, String text) {
        element.shouldBe(visible).clear();
        element.sendKeys(text);
    }

    protected void waitForElement(SelenideAppiumElement element) {
        element.shouldBe(visible, Duration.ofSeconds(15));
    }

    protected boolean isElementVisible(SelenideAppiumElement element) {
        return element.is(visible, Duration.ofSeconds(15));
    }

    protected String getTextFromParentContainers(SelenideAppiumElement element) {
        return element.shouldBe(visible, Duration.ofSeconds(15))
                .findElement(By.className("android.widget.TextView"))
                .getText();
    }

    protected String getTextFromElement(SelenideAppiumElement element) {
        return element.shouldBe(visible, Duration.ofSeconds(15)).getText();
    }

    public NavigationMenu getNavigationMenu() {
        return new NavigationMenu();
    }

    public void pressBackButton() {
        driver.navigate().back();
    }

    @Step("{0}")
    public void announceStep(String message){
    }
}
