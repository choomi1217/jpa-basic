package org.example.ch6.practice.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
    private String city;
    private String street;
    private String zipcode;

    public Delivery(String city, String street, String zipcode) {
        this.status = DeliveryStatus.READY;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
