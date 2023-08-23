package org.example.practice.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
public abstract class Item extends BaseEntity{
    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @OneToMany(mappedBy = "item")
    private List<CategoryItem> categoryItem = new ArrayList<>();

    public Item(String name, int price, int stockQuantity, Date date) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        super.setCreatedAt(date);
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
    public int getStockQuantity() {
        return stockQuantity;
    }

    public List<CategoryItem> getCategoryItem() {
        return categoryItem;
    }

    public void addCategoryItem(CategoryItem categoryItem) {
        this.categoryItem.add(categoryItem);
    }


}

