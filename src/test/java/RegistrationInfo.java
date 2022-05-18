import lombok.Data;

@Data
public class RegistrationInfo {
    String address;
    String date;
    String name;
    String fullName;
    String phoneNumber;


    public String getAddress() {
        return address;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

