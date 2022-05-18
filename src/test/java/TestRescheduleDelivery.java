import com.codeborne.selenide.Configuration;
import com.github.javafaker.Address;
import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import lombok.Data;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.openqa.selenium.Keys;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.SimpleFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class TestRescheduleDelivery {

    private static Faker faker;

    @BeforeAll
    static void setUpAll() {
        faker = new Faker(new Locale("ru"));
    }

//    @Test
//    public void shouldPreventSendRequestMultipleTimes() {
//
//        String address = faker.address().cityName();
//        String name = faker.name().fullName();
//        String phone = faker.phoneNumber().phoneNumber();
//
//        System.out.println(address);
//        System.out.println(name);
//        System.out.println(phone);
//    }

//        @Test
//    void shouldGenerateData(){
//        RegistrationInfo = DataGenerator.Registration.generateInfo("ru");
//    }
RegistrationInfo info = new RegistrationInfo();

    @Test
    public void cardDelivery() {

        String address = faker.address().cityName();
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().phoneNumber();

        Calendar c = new GregorianCalendar();
        c.add(Calendar.DAY_OF_YEAR, 5); // увеличиваем на 5 дня от текущей даты
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy"); //придаем нужный формат дате
        String date1 = format1.format(c.getTime());

        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue(info.getAddress());
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(info.getDate1());
        $("[name=\"name\"]").setValue(info.getName());
        $("[name=\"phone\"]").setValue(info.getPhone());
        $(withText("Я соглашаюсь с условиями")).click();
        $(byText("Запланировать")).click();
        $("[data-test-id=success-notification]").should(visible, Duration.ofSeconds(15));


//        Calendar c2 = new GregorianCalendar();
//        c2.add(Calendar.DAY_OF_YEAR, 7); // увеличиваем на 7 дня от текущей даты
//        SimpleDateFormat format2 = new SimpleDateFormat("dd.MM.yyyy"); //придаем нужный формат дате
//        String date2 = format2.format(c2.getTime());

        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(info.getDate2());
        $(byText("Запланировать")).click();
        $("[data-test-id=replan-notification]").should(visible, Duration.ofSeconds(15));
        $x("//span[text()=\"Перепланировать\"]").click();
        $x("//div[text()=\"Успешно!\"]").should(visible, Duration.ofSeconds(15));
    }
}
