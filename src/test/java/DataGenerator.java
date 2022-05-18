import com.github.javafaker.Faker;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

//@UtilityClass
public class RegistrationByCardInfo {
    Calendar c = new GregorianCalendar();
    c.add(Calendar.DAY_OF_YEAR,5); // увеличиваем на 5 дня от текущей даты
    SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy"); //придаем нужный формат дате
    String date1 = format1.format(c.getTime());

    Calendar c2 = new GregorianCalendar();
    c2.add(Calendar.DAY_OF_YEAR,7); // увеличиваем на 7 дня от текущей даты
    SimpleDateFormat format2 = new SimpleDateFormat("dd.MM.yyyy"); //придаем нужный формат дате
    String date2 = format2.format(c2.getTime());
    private static Faker faker;

    String address = faker.address().cityName();
    String name = faker.name().fullName();
    String phone = faker.phoneNumber().phoneNumber();


}

public class DataGenerator() {
    private DataGenerator() {
    }

    public static class Registration {
        private Registration() {
        }

        public static RegistrationByCardInfo generateByCard(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return new RegistrationByCardInfo(faker.name().fullName(), faker.finance().
                    creditCard(CreditCardType.MASTERCARD), LocalDate.now().plusYears(1));
        }
    }
}
