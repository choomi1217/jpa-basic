package org.example.ch10.jpql.join;

import org.example.ch10.jpql.entity.Member;
import org.example.ch10.jpql.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CollectionJoin {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT t, m FROM Team t JOIN t.members m WHERE t.name = :name";

        List<Object[]> resultList = em.createQuery(query).setParameter("name", "teamA").getResultList();

        resultList.forEach(o -> {
            System.out.println("--------------------");
            System.out.println("team name: " + ((Team) o[0]).getName());
            System.out.println("member name: " + ((Member) o[1]).getName());
            System.out.println("--------------------");
        });

    }
}
