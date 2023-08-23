package org.example.practice.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
public class Purchase extends BaseEntity{
    @Id @GeneratedValue
    @Column(name = "PURCHASE_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
    private List<PurchaseItem> purchaseItems = new ArrayList<PurchaseItem>();

    private Date purchaseDate;

    @Enumerated(EnumType.STRING)
    private PurchaseStatus status;

    public Purchase(Member member, Delivery delivery) {
        setMember(member);
        setDelivery(delivery);
        purchaseDate = new Date();
        status = PurchaseStatus.PURCHASE;
        super.setCreatedAt(new Date());
    }

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public List<PurchaseItem> getPurchaseItems() {
        return purchaseItems;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public PurchaseStatus getStatus() {
        return status;
    }

    public void setStatus(PurchaseStatus status) {
        this.status = status;
    }

    public void addPurchaseItem(PurchaseItem purchaseItem) {
        purchaseItems.add(purchaseItem);
        purchaseItem.setPurchase(this);
    }
}
