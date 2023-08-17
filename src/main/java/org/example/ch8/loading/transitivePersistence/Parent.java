package org.example.ch8.loading.transitivePersistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent extends Person{
    @Id @GeneratedValue
    @Column(name = "PARENT_ID")
    private Long id;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST)
    private List<Child> childList = new ArrayList<Child>();

    public Long getId() {
        return id;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void addChild(Child child) {
        childList.add(child);
        child.setParent(this);
    }
}
