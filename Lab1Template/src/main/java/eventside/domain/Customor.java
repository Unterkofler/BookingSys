package eventside.domain;

import java.time.LocalDate;

public class Customor {
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String postalZipCode;

    public Customor(String firstName, String lastName, String street, String city, String postalZipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.postalZipCode = postalZipCode;
    }
}
