package net.synaps.pages;

import net.synaps.test.TestBase;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TeamsPage extends TestBase {
    public TeamsPage() {
    }

    public TeamsPage checkPlaceCreate() {
        $(By.id("co.nomadlabs.chat:id/f__frame__action")).shouldHave(text("Create"));
        return this;
    }
}
