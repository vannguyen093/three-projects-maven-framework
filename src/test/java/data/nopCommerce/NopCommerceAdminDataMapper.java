package data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;

public class AdminDataMapper {

    @JsonProperty("customer")
    Customer customer;
    @JsonProperty("editCustomer")
    EditCustomer editCustomer;
    @JsonProperty("address")
    Address address;
    @JsonProperty("editAddress")
    EditAddress editAddress;

    public static AdminDataMapper getAdminData() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/src/test/resources/AdminData.json"), AdminDataMapper.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    static class Customer {
        @JsonProperty("firstName")
        private String firstName;
        @JsonProperty("lastName")
        private String lastName;
        @JsonProperty("email")
        private String email;
        @JsonProperty("password")
        private String password;
        @JsonProperty("gender")
        private String gender;
        @JsonProperty("dateOfBirth")
        private String dateOfBirth;
        @JsonProperty("customerRole")
        private String customerRole;
        @JsonProperty("company")
        private String company;
        @JsonProperty("adminComment")
        private String adminComment;
    }

    public String getFirstName() {
        return customer.firstName;
    }

    public String getLastName() {
        return customer.lastName;
    }

    public String getEmail() {
        return customer.email;
    }

    public String getPassword() {
        return customer.password;
    }

    public String getGender() {
        return customer.gender;
    }

    public String getDateOfBirth() {
        return customer.dateOfBirth;
    }

    public String getCustomerRole() {
        return customer.customerRole;
    }

    public String getCompany() {
        return customer.company;
    }

    public String getAdminComment() {
        return customer.adminComment;
    }

    static class EditCustomer {
        @JsonProperty("editFirstName")
        private String editFirstName;
        @JsonProperty("editLastName")
        private String editLastName;
        @JsonProperty("editEmail")
        private String editEmail;
        @JsonProperty("editPassword")
        private String editPassword;
        @JsonProperty("editGender")
        private String editGender;
        @JsonProperty("editDateOfBirth")
        private String editDateOfBirth;
        @JsonProperty("editCustomerRole")
        private String editCustomerRole;
        @JsonProperty("editCompany")
        private String editCompany;
        @JsonProperty("editAdminComment")
        private String editAdminComment;
    }

    public String getEditFirstName() {
        return editCustomer.editFirstName;
    }

    public String getEditLastName() {
        return editCustomer.editLastName;
    }

    public String getEditEmail() {
        return editCustomer.editEmail;
    }

    public String getEditPassword() {
        return editCustomer.editPassword;
    }

    public String getEditGender() {
        return editCustomer.editGender;
    }

    public String getEditDateOfBirth() {
        return editCustomer.editDateOfBirth;
    }

    public String getEditCustomerRole() {
        return editCustomer.editCustomerRole;
    }

    public String getEditCompany() {
        return editCustomer.editCompany;
    }

    public String getEditAdminComment() {
        return editCustomer.editAdminComment;
    }

    static class Address {
        @JsonProperty("addrFirstName")
        private String addrFirstName;
        @JsonProperty("addrLastName")
        private String addrLastName;
        @JsonProperty("addrEmail")
        private String addrEmail;
        @JsonProperty("addrCountry")
        private String addrCountry;
        @JsonProperty("addrState")
        private String addrState;
        @JsonProperty("addrCity")
        private String addrCity;
        @JsonProperty("addressStreet")
        private String addressStreet;
        @JsonProperty("addrZipCode")
        private String addrZipCode;
        @JsonProperty("addrPhoneNumber")
        private String addrPhoneNumber;
    }

    public String getAddrFirstName() {
        return address.addrFirstName;
    }

    public String getAddrLastName() {
        return address.addrLastName;
    }

    public String getAddrEmail() {
        return address.addrEmail;
    }

    public String getAddrCountry() {
        return address.addrCountry;
    }

    public String getAddrState() {
        return address.addrState;
    }

    public String getAddrCity() {
        return address.addrCity;
    }

    public String getAddressStreet() {
        return address.addressStreet;
    }

    public String getAddrZipCode() {
        return address.addrZipCode;
    }

    public String getAddrPhoneNumber() {
        return address.addrPhoneNumber;
    }

    static class EditAddress {
        @JsonProperty("editAddrFirstName")
        private String editAddrFirstName;
        @JsonProperty("editAddrLastName")
        private String editAddrLastName;
        @JsonProperty("editAddrEmail")
        private String editAddrEmail;
        @JsonProperty("editAddrCountry")
        private String editAddrCountry;
        @JsonProperty("editAddrState")
        private String editAddrState;
        @JsonProperty("editAddrCity")
        private String editAddrCity;
        @JsonProperty("editAddressStreet")
        private String editAddressStreet;
        @JsonProperty("editAddrZipCode")
        private String editAddrZipCode;
        @JsonProperty("editAddrPhoneNumber")
        private String editAddrPhoneNumber;
    }
    public String getEditAddrFirstName() {
        return editAddress.editAddrFirstName;
    }

    public String getEditAddrLastName() {
        return editAddress.editAddrLastName;
    }

    public String getEditAddrEmail() {
        return editAddress.editAddrEmail;
    }

    public String getEditAddrCountry() {
        return editAddress.editAddrCountry;
    }

    public String getEditAddrState() {
        return editAddress.editAddrState;
    }

    public String getEditAddrCity() {
        return editAddress.editAddrCity;
    }

    public String getEditAddressStreet() {
        return editAddress.editAddressStreet;
    }

    public String getEditAddrZipCode() {
        return editAddress.editAddrZipCode;
    }

    public String getEditAddrPhoneNumber() {
        return editAddress.editAddrPhoneNumber;
    }
}
