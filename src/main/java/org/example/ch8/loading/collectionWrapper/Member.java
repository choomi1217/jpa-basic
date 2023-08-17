package org.example.ch8.loading.collectionWrapper;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {
    @Id
    @Column(name = "MEMBER_ID")
    private String id;
    private String username;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TEAM_ID")
    private Team team;
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Purchase> purchases = new ArrayList<>();

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void addPurchase(Purchase purchase) {
        this.purchases.add(purchase);
    }
}
