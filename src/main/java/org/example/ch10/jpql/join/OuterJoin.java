package org.example.ch10.jpql.join;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class OuterJoin {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT m.name, t.name FROM Member m LEFT OUTER JOIN m.team t WHERE m.name = :name";

        List<Object[]> resultList = em.createQuery(query)
                .setParameter("name", "kim")
                .getResultList();

        resultList.forEach(o -> {
            System.out.println("--------------------");
            System.out.println("member name | " + o[0]);
            System.out.println("team name | " + o[1]);
            System.out.println("--------------------");
        });
    }
}
