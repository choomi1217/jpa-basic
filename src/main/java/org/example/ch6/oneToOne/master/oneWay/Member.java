package org.example.ch6.oneToOne.master.oneWay;

import javax.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "locker_id")
    private Locker locker;

    public Member(String name, Locker locker) {
        this.name = name;
        this.locker = locker;
    }
}
