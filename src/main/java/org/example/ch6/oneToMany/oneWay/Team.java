package org.example.ch6.oneToMany.oneWay;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Team {

    @Id @GeneratedValue
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn(name = "team_id")
    private List<Member> members = new ArrayList<Member>();

    public List<Member> getMembers() {
        return members;
    }

    public Team(String name) {
        this.name = name;
    }
}
