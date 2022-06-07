import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
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

    public static String generateDate1(int days1) {
        Faker faker = new Faker();
        Calendar c = new GregorianCalendar();
        c.add(Calendar.DAY_OF_YEAR, days1); // увеличиваем на 5 дня от текущей даты
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy"); //придаем нужный формат дате
        String date1 = format1.format(c.getTime());
        return date1;
    }

    public static String generateName(String local) {
        Faker faker = new Faker(new Locale(local));
        return faker.name().fullName();
    }

    public static String generatePhone(String local) {
        Faker faker = new Faker(new Locale(local));
        return faker.phoneNumber().phoneNumber();
    }

    public static String generateDate2(int days2) {
        Faker faker = new Faker();
        Calendar c = new GregorianCalendar();
        c.add(Calendar.DAY_OF_YEAR, days2); // увеличиваем на 5 дня от текущей даты
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy"); //придаем нужный формат дате
        String date2 = format1.format(c.getTime());
        return date2;
    }
}