package net.synaps.pages;

import com.codeborne.selenide.Condition;
import io.appium.java_client.android.AndroidDriver;
import net.synaps.test.TestBase;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AuthPage extends TestBase {
    public AuthPage() {
    }

    public AuthPage fillLogin(String login) {
        $(By.xpath("//android.widget.FrameLayout[@resource-id='co.nomadlabs.chat:id/f__login__email']/android.widget.LinearLayout/android.widget.EditText")).sendKeys(login);
        return this;
    }

    public AuthPage fillPassword(String password) {
        $(By.xpath("//android.widget.FrameLayout[@resource-id='co.nomadlabs.chat:id/f__login__password']/android.widget.LinearLayout/android.widget.EditText")).sendKeys(password);
        return this;
    }

    public AuthPage scrollToLoginSubmit(AndroidDriver driver) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                ".scrollIntoView(new UiSelector().resourceId(\"co.nomadlabs.chat:id/f__login__submit\").instance(0))");
        return this;
    }

    public TeamsPage clickLogin() {
        $(By.id("co.nomadlabs.chat:id/f__login__submit")).click();
        return new TeamsPage();
    }

    public AuthPage clickLoginError() {
        $(By.id("co.nomadlabs.chat:id/f__login__submit")).click();
        return this;
    }

    public AuthPage checkErrorCredentials() {
        $(By.id("co.nomadlabs.chat:id/f__login__error")).shouldHave(text("Wrong credentials"));
        return this;
    }
}
