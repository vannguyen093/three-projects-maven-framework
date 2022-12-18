package ultilities;

import com.github.javafaker.Faker;

import java.util.Locale;

public class LiveGuruDataHelper {
    private Locale local = new Locale("en");
    private Faker faker = new Faker(local);

    public static LiveGuruDataHelper getDataHelper() {
        return new LiveGuruDataHelper();
    }

    public String getFirstName() {
        return faker.name().firstName();
    }
    public String getLastName() {
        return faker.name().lastName();
    }
    public String getEmail() {
        return faker.internet().emailAddress();
    }
    public String getPassword() {
        return faker.internet().password();
    }
    public String getAddress() {
        return faker.address().fullAddress();
    }
    public String getCity() {
        return faker.address().city();
    }
    public String getTelephone() {
        return faker.phoneNumber().cellPhone();
    }
}
