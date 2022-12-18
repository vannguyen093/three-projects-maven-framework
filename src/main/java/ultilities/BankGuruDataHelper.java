package ultilities;

import com.github.javafaker.Faker;

import java.util.Locale;

public class BankGuruDataHelper {
    private Locale local = new Locale("en");
    private Faker faker = new Faker(local);

    public static BankGuruDataHelper getDataHelper() {
        return new BankGuruDataHelper();
    }

    public String getCustomerName() {
        return faker.name().fullName();
    }

    public String getAddress() {
        return faker.address().streetAddress();
    }

    public String getCity() {
        return faker.address().city();
    }

    public String getState() {
        return faker.address().state();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getPhone() {
        return faker.phoneNumber().cellPhone().replace("-", "");
    }

    public String getPassword() {
        return faker.internet().password();
    }
}
