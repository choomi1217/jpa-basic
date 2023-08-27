package org.example.ch10.jpql.join;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class InnerJoin {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT m.name, t.name FROM Member m JOIN m.team t WHERE t.name = :name";

        List<Object[]> resultList = em.createQuery(query)
                .setParameter("name", "teamA")
                .getResultList();

        resultList.forEach(o -> {
            System.out.println("member name: " + o[0]);
            System.out.println("team name: " + o[1]);
        });
    }
}
