package problems.project2.model;

public class Address {
    private String city, state, country;
    private int pincode, houseNumber;

    public Address(int houseNumber, String city, String state, String country, int pincode) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
        this.houseNumber = houseNumber;
    }

    public Address(Address address, int houseNumber) {
        this.city = address.city;
        this.state = address.state;
        this.country = address.country;
        this.pincode = address.pincode;
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String fullAddress() {
        return String.format("%d, %s, %s, %s, %d", houseNumber, city, state, country, pincode);
    }

    @Override
    public String toString() {
        return String.format("Address {houseNumber=%s, city=%s, state=%s, country=%s, pincode=%s}", houseNumber, city, state, country, pincode);
    }
}

