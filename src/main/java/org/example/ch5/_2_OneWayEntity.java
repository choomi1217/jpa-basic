package org.example.ch5;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

public class _2_OneWayEntity {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        OneWayTeam oneWayTeam = new OneWayTeam("team1", "팀1");
        em.persist(oneWayTeam);

        OneWayPlayer oneWayPlayer = new OneWayPlayer("member1", "회원1");
        oneWayPlayer.setOneWayTeam(oneWayTeam);
        em.persist(oneWayPlayer);

        OneWayTeam playerOneWayTeam = oneWayPlayer.getOneWayTeam();
        System.out.println("playerTeam = " + playerOneWayTeam.getName());

        jpqlLogin(em);

        OneWayTeam oneWayTeam2 = new OneWayTeam("team2", "팀2");
        em.persist(oneWayTeam2);

        OneWayPlayer findOneWayPlayer = em.find(OneWayPlayer.class, "member1");
        findOneWayPlayer.setOneWayTeam(oneWayTeam2);

        findOneWayPlayer.setOneWayTeam(null);

        tx.commit();
        emf.close();

    }

    private static void jpqlLogin(EntityManager em){
        String jpql = "select p from OneWayPlayer p join p.oneWayTeam t where t.name = :teamName";
        List<OneWayPlayer> resultList = em.createQuery(jpql, OneWayPlayer.class)
                .setParameter("teamName", "팀1")
                .getResultList();
        resultList.forEach(oneWayPlayer -> System.out.println("player = " + oneWayPlayer.getUsername()));
    }

}

@Entity
@NoArgsConstructor
class OneWayPlayer {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private OneWayTeam oneWayTeam;

    public OneWayPlayer(String id, String username) {
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

    public OneWayTeam getOneWayTeam() {
        return oneWayTeam;
    }

    public void setOneWayTeam(OneWayTeam oneWayTeam) {
        this.oneWayTeam = oneWayTeam;
    }
}

@Entity
@NoArgsConstructor
class OneWayTeam {
    @Id
    @Column(name = "TEAM_ID")
    private String id;
    private String name;

    public OneWayTeam(String id, String name) {
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
}