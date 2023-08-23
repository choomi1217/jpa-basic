package org.example.ch9.embeddedValue.simple;

import javax.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;
    private int age;

    //근무 기간
    @Embedded Period workPeriod;
    //집 주소
    @Embedded Address homeAddress;
}

@Embeddable
class Period {
    @Temporal(TemporalType.DATE) java.util.Date startDate;
    @Temporal(TemporalType.DATE) java.util.Date endDate;
}

@Embeddable
class Address {
    private String city;
    private String street;
    private String zipcode;
}