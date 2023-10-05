package org.example.ch10.jpql.join;

import org.example.ch10.jpql.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class SubQuery {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();

        all(em);
        //exists(em);
        //size(em);
        //count(em);
        //avg(em);
    }

    private static void all(EntityManager em) {
        String query = "SELECT m FROM Member m WHERE m.age > ALL (SELECT m2.age FROM Member m2)";
        List<Member> resultList = em.createQuery(query, Member.class).getResultList();
        resultList.forEach(member -> {
            System.out.println("member name: " + member.getName());
        });
    }

    private static void exists(EntityManager em) {
        String query = "SELECT m FROM Member m WHERE EXISTS (SELECT t FROM m.team t WHERE t.name = 'teamA')";
        List<Member> resultList = em.createQuery(query, Member.class).getResultList();
        resultList.forEach(member -> {
            System.out.println("member name: " + member.getName());
        });
    }


    private static void size(EntityManager em) {
        String query = "SELECT m FROM Member m WHERE m.orders.size = 0";
        em.createQuery(query, Member.class).getResultList().forEach(member -> {
            System.out.println("member name: " + member.getName());
        });
    }


    private static void count(EntityManager em) {
        String query = "SELECT m FROM Member m WHERE (SELECT COUNT(o) FROM Order o WHERE m = o.member) = 0";
        em.createQuery(query, Member.class).getResultList().forEach(member -> {
            System.out.println("member name: " + member.getName());
        });
    }

    private static void avg(EntityManager em) {
        String query = "SELECT m FROM Member m WHERE m.age > (SELECT AVG(m2.age) FROM Member m2)";
        em.createQuery(query, Member.class).getResultList().forEach(member -> {
            System.out.println("member name: " + member.getName());
        });
    }


}
