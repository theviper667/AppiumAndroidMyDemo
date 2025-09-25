package models;

public class ShippingAddress {
    private final String fullname;
    private final String addressline1;
    private final String city;
    private final String zipcode;
    private final String country;

    public ShippingAddress (String fullname, String addressline1, String city, String zipcode, String country) {
        this.fullname = fullname;
        this.addressline1 = addressline1;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
    }

    public String getFullName() {
        return fullname;
    }

    public String getAddressLine1() {
        return addressline1;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipcode;
    }

    public String getCountry() {
        return country;
    }
}
