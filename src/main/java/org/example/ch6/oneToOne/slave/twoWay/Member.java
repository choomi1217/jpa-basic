package org.example.ch6.oneToOne.slave.twoWay;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "locker_id")
    private Locker locker;

    public Member(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        if (this.locker != null) {
            this.locker.setMember(null);
        }
        this.locker = locker;
        if(locker != null) {
            locker.setMember(this);
        }
    }
}
