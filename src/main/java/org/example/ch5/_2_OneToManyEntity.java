package org.example.ch5;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

public class _2_OneToManyEntity {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Team team = new Team("team1", "팀1");
        em.persist(team);

        Player player = new Player("member1", "회원1");
        player.setTeam(team);
        em.persist(player);

        Team playerTeam = player.getTeam();
        System.out.println("playerTeam = " + playerTeam.getName());

        jpqlLogin(em);

        Team team2 = new Team("team2", "팀2");
        em.persist(team2);

        Player findPlayer = em.find(Player.class, "member1");
        findPlayer.setTeam(team2);

        findPlayer.setTeam(null);

        tx.commit();
        emf.close();

    }

    private static void jpqlLogin(EntityManager em){
        String jpql = "select p from Player p join p.team t where t.name = :teamName";
        List<Player> resultList = em.createQuery(jpql, Player.class)
                .setParameter("teamName", "팀1")
                .getResultList();
        resultList.forEach(player -> System.out.println("player = " + player.getUsername()));
    }

}

@Entity
@NoArgsConstructor
class Player {

    @Id
    @Column(name = "MEMBER_ID")
    private String id;
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Player(String id, String username) {
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}

@Entity
@NoArgsConstructor
class Team{
    @Id
    @Column(name = "TEAM_ID")
    private String id;
    private String name;

    public Team(String id, String name) {
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