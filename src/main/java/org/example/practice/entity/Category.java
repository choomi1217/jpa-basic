package org.example.practice.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@NoArgsConstructor
public class Category extends BaseEntity{
    @Id @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Long id;
    private Long parentId;
    private String name;

    public Category(String name) {
        this.parentId = null;
        this.name = name;
        super.setCreatedAt(new Date());
    }

    public Category(Long parentId, String name) {
        super.setCreatedAt(new Date());
        this.parentId = parentId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
