package org.example.ch9.basicValue;

import javax.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;
    private int age;
    //근무 기간
    @Temporal(TemporalType.DATE) java.util.Date startzDate;
    @Temporal(TemporalType.DATE) java.util.Date endDate;

    //집 주소
    private String city;
    private String street;
    private String zipcode;
}
