package org.example.ch6.manyToMany.relationTable.compositeKey;

import java.io.Serializable;

public class MemberProductId implements Serializable {
    private Long member;
    private Long product;

    public Long getMember() {
        return member;
    }

    public void setMember(Long member) {
        this.member = member;
    }

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }
}
