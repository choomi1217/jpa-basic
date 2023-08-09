package org.example.ch7.composeKey.discriminator.idClass;

import javax.persistence.*;

@Entity
@IdClass(GrandChildId.class)
public class GrandChild {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "PARENT_ID"),
        @JoinColumn(name = "CHILD_ID")
    })
    private Child child;

    @Id @GeneratedValue
    @Column(name = "GRANDCHILD_ID")
    private Long grandChildId;

    private String name;

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public Long getGrandChildId() {
        return grandChildId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
