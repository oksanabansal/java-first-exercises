package oksana.java.exercises.first.entities;

public class AddressEntity {

    private String firstName;
    private String middleName;
    private String lastName;
    private String streetName;
    private String houseNumber;
    private String addition;
    private String districtName;
    private String city;
    private String postalCode;
    private String country;

    public AddressEntity(final String firstName,
                         final String middleName,
                         final String lastName,
                         final String streetName,
                         final String houseNumber,
                         final String addition,
                         final String districtName,
                         final String city,
                         final String postalCode,
                         final String country) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.addition = addition;
        this.districtName = districtName;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getAddition() {
        return addition;
    }

    public String getDistrictName() {
        return districtName;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String   toString() {
        return "AddressEntity{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", streetName='" + streetName + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", addition='" + addition + '\'' +
                ", districtName='" + districtName + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
