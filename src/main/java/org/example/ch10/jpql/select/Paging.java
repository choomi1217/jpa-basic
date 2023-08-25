package org.example.ch10.jpql.select;

import org.example.ch10.jpql.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Paging {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        List<Member> resultList = em.createQuery("SELECT m FROM Member m", Member.class)
                .setFirstResult(3)
                .setMaxResults(10)
                .getResultList();
    }
}
