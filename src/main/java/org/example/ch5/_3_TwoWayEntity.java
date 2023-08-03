package org.example.ch5;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class _3_TwoWayEntity {
    public static void main(String[] args) {
        //jpa();
        pureJava();
    }

    private static void pureJava() {
        TwoWayTeam twoWayTeam = new TwoWayTeam("team1", "팀1");
        TwoWayPlayer player1 = new TwoWayPlayer("member1", "회원1");
        TwoWayPlayer player2 = new TwoWayPlayer("member2", "회원2");
        player1.setTwoWayTeam(twoWayTeam);
        player2.setTwoWayTeam(twoWayTeam);
        List<TwoWayPlayer> twoWayPlayers = twoWayTeam.getTwoWayPlayers();
        System.out.println(twoWayPlayers.size());
    }

    private static void jpa() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        insert(em, tx);
        TwoWayTeam twoWayTeam = em.find(TwoWayTeam.class, "team1");
        List<TwoWayPlayer> twoWayPlayers = twoWayTeam.getTwoWayPlayers();
        twoWayPlayers.forEach(player -> System.out.println("player = " + player.getUsername()));
        emf.close();
    }

    private static void insert(EntityManager em, EntityTransaction tx) {
        tx.begin();
        TwoWayTeam twoWayTeam = new TwoWayTeam("team1", "팀1");
        em.persist(twoWayTeam);
        TwoWayPlayer player1 = new TwoWayPlayer("member1", "회원1");
        player1.setTwoWayTeam(twoWayTeam);
        TwoWayPlayer player2 = new TwoWayPlayer("member2", "회원2");
        player2.setTwoWayTeam(twoWayTeam);
        em.persist(player1);
        em.persist(player2);
        tx.commit();
    }

}

@Entity
@NoArgsConstructor
class TwoWayPlayer{
    @Id
    @Column(name = "MEMBER_ID")
    private String id;
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private TwoWayTeam twoWayTeam;

    public TwoWayPlayer(String id, String username) {
        this.id = id;
        this.username = username;
    }

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

    public TwoWayTeam getTwoWayTeam() {
        return twoWayTeam;
    }

    public void setTwoWayTeam(TwoWayTeam twoWayTeam) {
        if(this.twoWayTeam != null) {
            this.twoWayTeam.getTwoWayPlayers().remove(this);
        }
        if (!twoWayTeam.getTwoWayPlayers().contains(this)) {
            twoWayTeam.getTwoWayPlayers().add(this);
        }
        this.twoWayTeam = twoWayTeam;
    }
}

@Entity
@NoArgsConstructor
class TwoWayTeam{
    @Id
    @Column(name = "TEAM_ID")
    private String id;
    private String name;
    @OneToMany(mappedBy = "twoWayTeam", fetch = FetchType.EAGER)
    private List<TwoWayPlayer> twoWayPlayers = new ArrayList<TwoWayPlayer>();

    public TwoWayTeam(String id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public List<TwoWayPlayer> getTwoWayPlayers() {
        return twoWayPlayers;
    }

    public void setTwoWayPlayers(List<TwoWayPlayer> twoWayPlayers) {
        this.twoWayPlayers = twoWayPlayers;
    }
}
