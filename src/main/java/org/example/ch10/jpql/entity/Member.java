package org.example.ch10.jpql.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;
    private int age;
    @Embedded
    private Address address;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @OneToMany
    @JoinColumn(name = "MEMBER_ORDER_ID")
    private List<Order> orders = new ArrayList<Order>();

    @OneToMany
    @JoinColumn(name = "MEMBER_PRODUCT_ID")
    private List<Product> products = new ArrayList<Product>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public Team getTeam() {
        return team;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void addOrder(Order order) {
        if (!this.orders.contains(order)){
            this.orders.add(order);
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        if (!this.products.contains(product)){
            this.products.add(product);
        }
    }
}
