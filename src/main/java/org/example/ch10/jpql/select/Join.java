package org.example.ch10.jpql.select;

import org.example.ch10.jpql.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Join {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT m FROM Member m JOIN m.team t WHERE t.name = :name";
        List<Team> resultList = em.createQuery(query, Team.class)
                .setParameter("name", "teamA")
                .getResultList();

        resultList.forEach(team -> System.out.println(team.getName()));
    }
}
