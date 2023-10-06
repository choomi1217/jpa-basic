package org.example.ch10.jpql.join;

import org.example.ch10.jpql.entity.Member;
import org.example.ch10.jpql.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class SubQuery {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();

        memberOf(em);
        isEmpty(em);
        isNull(em);
        like(em);
        all(em);
        exists(em);
        size(em);
        count(em);
        avg(em);
    }

    private static void memberOf(EntityManager em) {
        System.out.println(" ----- IS MEMBER OF -----");
        Member member = em.find(Member.class, 1L);
        String query = "SELECT t FROM Team t WHERE :memberParam MEMBER OF t.members";
        List<Team> resultList = em.createQuery(query, Team.class).setParameter("memberParam", member).getResultList();
        resultList.forEach(team -> {
            System.out.println("member name: " + team.getName());
        });
    }

    private static void isEmpty(EntityManager em) {
        System.out.println(" ----- IS EMPTY -----");
        String query = "SELECT m FROM Member m WHERE m.orders IS EMPTY";
        List<Member> resultList = em.createQuery(query, Member.class).getResultList();
        resultList.forEach(member -> {
            System.out.println("member name: " + member.getName());
        });
    }

    private static void isNull(EntityManager em) {
        System.out.println(" ----- IS NULL -----");
        String query = "SELECT m FROM Member m WHERE m.team IS NULL";
        List<Member> resultList = em.createQuery(query, Member.class).getResultList();
        resultList.forEach(member -> {
            System.out.println("member name: " + member.getName());
        });
    }

    private static void like(EntityManager em) {
        System.out.println(" ----- LIKE ----- ");
        String query = "SELECT m FROM Member m WHERE m.name LIKE '%cho%'";
        List<Member> resultList = em.createQuery(query, Member.class).getResultList();
        resultList.forEach(member -> {
            System.out.println("member name: " + member.getName());
        });
    }

    private static void all(EntityManager em) {
        System.out.println(" ----- ALL ----- ");
        String query = "SELECT m FROM Member m WHERE m.age > ALL (SELECT m2.age FROM Member m2)";
        List<Member> resultList = em.createQuery(query, Member.class).getResultList();
        resultList.forEach(member -> {
            System.out.println("member name: " + member.getName());
        });
    }

    private static void exists(EntityManager em) {
        System.out.println(" ----- EXISTS ----- ");
        String query = "SELECT m FROM Member m WHERE EXISTS (SELECT t FROM m.team t WHERE t.name = 'teamA')";
        List<Member> resultList = em.createQuery(query, Member.class).getResultList();
        resultList.forEach(member -> {
            System.out.println("member name: " + member.getName());
        });
    }


    private static void size(EntityManager em) {
        System.out.println(" ----- SIZE ----- ");
        String query = "SELECT m FROM Member m WHERE m.orders.size = 0";
        em.createQuery(query, Member.class).getResultList().forEach(member -> {
            System.out.println("member name: " + member.getName());
        });
    }


    private static void count(EntityManager em) {
        System.out.println(" ----- COUNT ----- ");
        String query = "SELECT m FROM Member m WHERE (SELECT COUNT(o) FROM Order o WHERE m = o.member) = 0";
        em.createQuery(query, Member.class).getResultList().forEach(member -> {
            System.out.println("member name: " + member.getName());
        });
    }

    private static void avg(EntityManager em) {
        System.out.println(" ----- AVG ----- ");
        String query = "SELECT m FROM Member m WHERE m.age > (SELECT AVG(m2.age) FROM Member m2)";
        em.createQuery(query, Member.class).getResultList().forEach(member -> {
            System.out.println("member name: " + member.getName());
        });
    }


}
