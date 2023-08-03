package org.example.ch6.manyToOne;

import javax.persistence.*;

public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
