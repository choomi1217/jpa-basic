package org.example.ch10.jpql.entity;

import org.example.practice.entity.Address;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;
    private int orderAmount;
    @Embedded
    private Address address;


}
