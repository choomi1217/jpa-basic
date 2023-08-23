package org.example.practice.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Delivery extends BaseEntity{
    @Id @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
    @Embedded
    private Address address;
    public Delivery(Address address) {
        this.address = address;
        super.setCreatedAt(new Date());
        this.status = DeliveryStatus.READY;
    }

    public Delivery() { }
}
