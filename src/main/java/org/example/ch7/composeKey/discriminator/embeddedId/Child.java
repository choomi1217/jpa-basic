package org.example.ch7.composeKey.discriminator.embeddedId;

import javax.persistence.*;

@Entity
public class Child {
    @EmbeddedId
    private ChildId id;
    @MapsId("parentId")
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Parent parent;
    private String name;

    public ChildId getId() {
        return id;
    }

    public void setId(ChildId id) {
        this.id = id;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
