package org.example.ch10.jpql.join.pathExpressions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 컬렉션 값 연관 경로탐색
 * */
public class CollectionAssociationValue {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();

        String sql = "SELECT m.name FROM Team t join t.members m WHERE t.name = 'teamA'";

        em.createQuery(sql, String.class).getResultList().forEach(System.out::println);
    }
}
