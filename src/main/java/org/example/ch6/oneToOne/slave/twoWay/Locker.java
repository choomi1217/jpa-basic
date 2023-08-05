package org.example.ch6.oneToOne.slave.twoWay;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Locker {
    @Id @GeneratedValue
    @Column(name = "locker_id")
    private Long id;
    private String name;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Locker(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        if(this.member != null){
            this.member.setLocker(null);
        }
        this.member = member;
        if(member.getLocker() != this){
            member.setLocker(this);
        }
    }
}
