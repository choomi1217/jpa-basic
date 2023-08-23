package org.example.practice.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class PurchaseItem {
    @Id @GeneratedValue
    @Column(name = "PURCHASE_ITEM_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PURCHASE_ID")
    private Purchase purchase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    private int purchasePrice;

    private int count;

    public PurchaseItem(Purchase purchase, Item item, int count) {
        this.purchase = purchase;
        this.item = item;
        this.purchasePrice = item.getPrice() * count;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public Item getItem() {
        return item;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getCount() {
        return count;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
