import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class TestRescheduleDelivery {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    public void setUp() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
    }

    @Test
    public void cardDelivery() {

        var name = DataGenerator.generateName("ru");
        var address = DataGenerator.generateAddress("ru");
        var date1 = DataGenerator.generateDate(5);
        var date2 = DataGenerator.generateDate(7);
        var phone = DataGenerator.generatePhone("ru");

        $("[data-test-id='city'] input").setValue(address);
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(date1);
        $("[name=\"name\"]").setValue(name);
        $("[name=\"phone\"]").setValue(phone);
        $(withText("Я соглашаюсь с условиями")).click();
        $(byText("Запланировать")).click();
        $("[data-test-id='success-notification']").should(matchText(date1), Duration.ofSeconds(15));

        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(date2);
        $(byText("Запланировать")).click();
        $("[data-test-id=replan-notification]").should(visible, Duration.ofSeconds(15));
        $x("//span[text()=\"Перепланировать\"]").click();
        $("[data-test-id='success-notification']").should(matchText(date2), Duration.ofSeconds(15));
    }
}
