package org.example.practice.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
public class Delivery extends BaseEntity{
    @Id @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
    private String city;
    private String street;
    private String zipcode;

    public Delivery(String city, String street, String zipcode) {
        super.setCreatedAt(new Date());
        this.status = DeliveryStatus.READY;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
