package org.example.ch10.jpql.join;

import org.example.ch10.jpql.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ThetaJoin {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT m.team, m.id, m.name, t.name FROM Member m, Team t WHERE m.name = t.name";
        List<Object[]> resultList = em.createQuery(query).getResultList();
        resultList.forEach(o -> {
            Team team = (Team) o[0];
            System.out.println("--------------------");
            System.out.println("member id: " + o[1]);
            System.out.println("member name: " + o[2]);
            System.out.println("member's team name: " + team.getName());
            System.out.println("joined team name: " + o[3]);
            System.out.println("--------------------");
        });

    }
}
