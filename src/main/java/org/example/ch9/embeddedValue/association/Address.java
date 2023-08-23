package org.example.ch9.embeddedValue.association;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Address {
    private String city;
    private String street;
    @Embedded Zipcode zip;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Zipcode getZip() {
        return zip;
    }

    public void setZip(Zipcode zip) {
        this.zip = zip;
    }
}
