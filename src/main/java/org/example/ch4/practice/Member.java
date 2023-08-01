package org.example.ch4.practice;

import javax.persistence.*;

@Entity
@Table(name = "member_practice")
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String city;
    private String street;
    private String zipcode;



}
