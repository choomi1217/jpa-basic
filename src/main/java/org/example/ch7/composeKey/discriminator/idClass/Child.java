package org.example.ch7.composeKey.discriminator.idClass;

import javax.persistence.*;

@Entity
@IdClass(ChildId.class)
public class Child {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Parent parent;

    @Id @GeneratedValue
    @Column(name = "CHILD_ID")
    private Long childId;

    private String name;

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Long getChildId() {
        return childId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
