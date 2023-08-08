package org.example.ch7.commonProperty.override;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Entity;

@Entity
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @javax.persistence.Column(name = "SELLER_ID")),
    @AttributeOverride(name = "name", column = @javax.persistence.Column(name = "SELLER_NAME"))
})
public class Seller extends BaseEntity {
    private String shopName;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
