package org.example.ch10.jpql.join.fetch;

import org.example.ch10.jpql.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * 페치조인과 일반조회의 차이
 * */
public class CommonFetchDifference {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();

        String commonQuery = "SELECT t FROM Team t JOIN t.members m WHERE t.name in (:names)";

        List<Team> commonResult = em.createQuery(commonQuery, Team.class)
                .setParameter("names", "teamA")
                .getResultList();

        System.out.println("-------");

        String fetchQuery = "SELECT t FROM Team t JOIN FETCH t.members WHERE t.name in (:names)";

        List<Team> fetchResult = em.createQuery(fetchQuery, Team.class)
                .setParameter("names", "teamA")
                .getResultList();

    }
}
