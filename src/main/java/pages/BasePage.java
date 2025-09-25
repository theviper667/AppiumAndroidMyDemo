package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppiumElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.math.BigDecimal;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static core.AppiumDriverProvider.driver;

public class BasePage {

    protected void click(SelenideElement element) {
        element.scrollTo().shouldBe((visible), Duration.ofSeconds(15)).click();
    }

    protected void type(SelenideElement element, String text) {
        element.scrollTo().shouldBe(visible).clear();
        element.sendKeys(text);
    }

    protected void waitForElement(SelenideElement element) {
        element.scrollTo().shouldBe(visible, Duration.ofSeconds(15));
    }

    protected boolean isElementVisible(SelenideElement element) {
        return element.scrollTo().is(visible, Duration.ofSeconds(15));
    }

    protected String getTextFromParentContainers(SelenideAppiumElement element) {
        return element.shouldBe(visible, Duration.ofSeconds(15))
                .findElement(By.className("android.widget.TextView"))
                .getText();
    }

    protected BigDecimal extractCurrencyValue(SelenideElement element) {
        String convert =  element.shouldBe(visible, Duration.ofSeconds(15))
                .getText()
                .replaceAll("[^\\d.]", "");
        return new BigDecimal(convert);
    }

    protected String getTextFromElement(SelenideAppiumElement element) {
        return element.scrollTo().shouldBe(visible, Duration.ofSeconds(15)).getText();
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
