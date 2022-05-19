import com.github.javafaker.Faker;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.experimental.UtilityClass;
import org.junit.jupiter.api.BeforeEach;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;


public class DataGenerator {
    private DataGenerator() {
    }

    public String generateAddress(String local) {
        Faker faker = new Faker(new Locale(local));
       String address = faker.address().cityName();
        return address;
    }

    public String generateDate1(int days1) {
        Faker faker = new Faker();
        Calendar c = new GregorianCalendar();
        c.add(Calendar.DAY_OF_YEAR, days1); // увеличиваем на 5 дня от текущей даты
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy"); //придаем нужный формат дате
        String date1 = format1.format(c.getTime());
        return date1;
    }

    public String generateName(String local) {
        Faker faker = new Faker(new Locale(local));
        return faker.name().fullName();
    }

    public String generatePhone(String local) {
        Faker faker = new Faker(new Locale(local));
        return faker.phoneNumber().phoneNumber();
    }

    public String generateDate2(int days2) {
        Faker faker = new Faker();
        Calendar c = new GregorianCalendar();
        c.add(Calendar.DAY_OF_YEAR, days2); // увеличиваем на 5 дня от текущей даты
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy"); //придаем нужный формат дате
        String date2 = format1.format(c.getTime());
        return date2;
    }

    public static class Registration {

        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
           // UserInfo user = new UserInfo(, );
return new UserInfo();
        }
//        public static RegistrationInfo generateUser(String local, int days1, int days2) {
//
//            RegistrationInfo user = new RegistrationInfo();
//            Faker faker = new Faker(new Locale(local));
//
//            Calendar c = new GregorianCalendar();
//            c.add(Calendar.DAY_OF_YEAR, days1); // увеличиваем на 5 дня от текущей даты
//            SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy"); //придаем нужный формат дате
//            String date1 = format1.format(c.getTime());
//
//            Calendar c2 = new GregorianCalendar();
//            c2.add(Calendar.DAY_OF_YEAR, days2); // увеличиваем на 7 дня от текущей даты
//            SimpleDateFormat format2 = new SimpleDateFormat("dd.MM.yyyy"); //придаем нужный формат дате
//            String date2 = format2.format(c2.getTime());
//
//            String address = faker.address().cityName();
//            String name = faker.name().fullName();
//            String phone = faker.phoneNumber().phoneNumber();
//            return user;}


        @Value
        public static class UserInfo {
            String address;
            String date1;
            String name;
            String phone;
            String date2;
//            return new RegistrationInfo(
//                    faker.address().cityName(),
//                    format1.format(c.getTime()),
//                    faker.name().fullName(),
//                    faker.phoneNumber().phoneNumber(),
//                    format2.format(c2.getTime()));
        }

    }
}


