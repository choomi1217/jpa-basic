package org.example.ch8.proxy.accessType.property;

import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
public class Member {


    private String id;

    private String username;

    private Team team;

    @Id
    @Column(name = "MEMBER_ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @ManyToOne(targetEntity = Team.class)
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
