package org.example.ch9.embeddedValue.duplicate;

import javax.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;

    @Embedded private Address houseAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "COMPANY_CITY")),
            @AttributeOverride(name = "street", column = @Column(name = "COMPANY_STREET")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "COMPANY_ZIPCODE"))
    })
    private Address companyAddress;
}

@Embeddable
class Address {
    private String city;
    private String street;
    private String zipcode;
}
