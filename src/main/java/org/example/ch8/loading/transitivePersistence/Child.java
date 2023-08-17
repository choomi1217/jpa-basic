package org.example.ch8.loading.transitivePersistence;

import javax.persistence.*;

@Entity
public class Child extends Person{
    @Id @GeneratedValue
    @Column(name = "CHILD_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Parent parent;

    public Long getId() {
        return id;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
        if(!parent.getChildList().contains(this)){
            parent.getChildList().add(this);
        }
    }

}
