import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class TestRescheduleDelivery {

    @BeforeEach
    public void setUp(){
    Configuration.holdBrowserOpen = true;
    open("http://localhost:9999/");}

    @Test
    public void cardDelivery() {
        RegistrationInfo info= DataGenerator.Registration.generateUser("ru", 5,7);

        $("[data-test-id='city'] input").setValue(info.getAddress());
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(info.getDate1());
        $("[name=\"name\"]").setValue(info.getName());
        $("[name=\"phone\"]").setValue(info.getPhone());
        $(withText("Я соглашаюсь с условиями")).click();
        $(byText("Запланировать")).click();
        $("[data-test-id=success-notification]").should(visible, Duration.ofSeconds(15));

        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(info.getDate2());
        $(byText("Запланировать")).click();
        $("[data-test-id=replan-notification]").should(visible, Duration.ofSeconds(15));
        $x("//span[text()=\"Перепланировать\"]").click();
        $x("//div[text()=\"Успешно!\"]").should(visible, Duration.ofSeconds(15));
    }
}
