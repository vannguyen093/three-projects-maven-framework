package data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;

public class UserDataMapper {

    @JsonProperty("user")
    Customer customer;
    @JsonProperty("editUser")
    EditCustomer editCustomer;
    @JsonProperty("addressesInfo")
    AddressesInfo addressesInfo;

    public static UserDataMapper getUserData() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/src/test/resources/UserData.json"), UserDataMapper.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String getFirstName() {
        return customer.firstName;
    }

    public String getLastName() {
        return customer.lastName;
    }

    public String getGender() {
        return customer.gender;
    }

    public String getEmail() {
        return customer.email;
    }

    public String getPassword() {
        return customer.password;
    }

    public String getDate() {
        return customer.date;
    }

    public String getMonth() {
        return customer.month;
    }

    public String getYear() {
        return customer.year;
    }

    public String getEditFirstName() {
        return editCustomer.editFirstName;
    }

    public String getEditLastName() {
        return editCustomer.editLastName;
    }

    public String getEditGender() {
        return editCustomer.editGender;
    }

    public String getEditEmail() {
        return editCustomer.editEmail;
    }

    public String getEditPassword() {
        return editCustomer.editPassword;
    }

    public String getEditDate() {
        return editCustomer.editDate;
    }

    public String getEditMonth() {
        return editCustomer.editMonth;
    }

    public String getEditYear() {
        return editCustomer.editYear;
    }

    public String getAddressFirstName() {
        return addressesInfo.addressFirstName;
    }

    public String getAddressLastName() {
        return addressesInfo.addressLastName;
    }

    public String getAddressEmail() {
        return addressesInfo.addressEmail;
    }

    public String getAddressCompany() {
        return addressesInfo.addressCompany;
    }

    public String getAddressCountry() {
        return addressesInfo.addressCountry;
    }

    public String getAddressState() {
        return addressesInfo.addressState;
    }

    public String getAddressCity() {
        return addressesInfo.addressCity;
    }

    public String getAddressStreet() {
        return addressesInfo.addressStreet;
    }

    public String getAddressZip() {
        return addressesInfo.addressZip;
    }

    public String getAddressPhone() {
        return addressesInfo.addressPhone;
    }

    static class Customer {
        @JsonProperty("firstName")
        String firstName;
        @JsonProperty("lastName")
        String lastName;
        @JsonProperty("gender")
        String gender;
        @JsonProperty("email")
        String email;
        @JsonProperty("password")
        String password;
        @JsonProperty("date")
        String date;
        @JsonProperty("month")
        String month;
        @JsonProperty("year")
        String year;
    }

    static class EditCustomer {
        @JsonProperty("editFirstName")
        private String editFirstName;
        @JsonProperty("editLastName")
        private String editLastName;
        @JsonProperty("editGender")
        private String editGender;
        @JsonProperty("editEmail")
        private String editEmail;
        @JsonProperty("editPassword")
        private String editPassword;
        @JsonProperty("editDate")
        private String editDate;
        @JsonProperty("editMonth")
        private String editMonth;
        @JsonProperty("editYear")
        private String editYear;
    }

    static class AddressesInfo {
        @JsonProperty("addressFirstName")
        String addressFirstName;
        @JsonProperty("addressLastName")
        String addressLastName;
        @JsonProperty("addressEmail")
        String addressEmail;
        @JsonProperty("addressCompany")
        String addressCompany;
        @JsonProperty("addressCountry")
        String addressCountry;
        @JsonProperty("addressState")
        String addressState;
        @JsonProperty("addressCity")
        String addressCity;
        @JsonProperty("addressStreet")
        String addressStreet;
        @JsonProperty("addressZip")
        String addressZip;
        @JsonProperty("addressPhone")
        String addressPhone;
    }

}
