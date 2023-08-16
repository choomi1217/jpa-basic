package org.example.ch8.proxy.accessType.property;

import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
public class Team {
    private String id;
    private String name;

    @Id
    @Column(name = "TEAM_ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
