package org.example.practice.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
public class Member extends BaseEntity{
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "member")
    private List<Purchase> purchases = new ArrayList<Purchase>();

    public Member(String name, Address address) {
        this.name = name;
        this.address = address;
        super.setCreatedAt(new Date());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void addPurchase(Purchase purchase) {
        this.purchases.add(purchase);
        if (purchase.getMember() != this) {
            purchase.setMember(this);
        }
    }
}
