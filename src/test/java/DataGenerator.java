import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;


public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateAddress(String local) {
        Faker faker = new Faker(new Locale(local));
        String address = faker.address().cityName();
        return address;
    }

    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateName(String local) {
        Faker faker = new Faker(new Locale(local));
        return faker.name().fullName();
    }

    public static String generatePhone(String local) {
        Faker faker = new Faker(new Locale(local));
        return faker.phoneNumber().phoneNumber();
    }
}