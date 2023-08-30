package org.example.ch10.jpql.join.fetch;

import org.example.ch10.jpql.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * 많은 컬렉션들은 페치조인할 수 없다.
 * */
public class ManyCollections {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();

        String sql = "SELECT m FROM Member m JOIN FETCH m.orders o JOIN FETCH m.products p WHERE m.name = :name";

        List<Member> resultList = em.createQuery(sql, Member.class)
                .setParameter("name", "hong")
                .getResultList();

    }
}
