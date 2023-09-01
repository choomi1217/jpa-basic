package org.example.ch10.jpql.join;

import org.example.ch10.jpql.entity.Member;
import org.example.ch10.jpql.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class SubQuery {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();

        //subQuery1(em);
        //subQuery2(em);
        //subQuery3(em);
        exists(em);

    }

    private static void exists(EntityManager em) {
        String query = "SELECT m FROM Member m WHERE EXISTS (SELECT t FROM m.team t WHERE t.name = 'teamA')";
        List<Member> resultList = em.createQuery(query, Member.class).getResultList();
        resultList.forEach(member -> {
            System.out.println("member name: " + member.getName());
        });
    }


    private static void subQuery3(EntityManager em) {
        String query = "SELECT m FROM Member m WHERE m.orders.size = 0";
        em.createQuery(query, Member.class).getResultList().forEach(member -> {
            System.out.println("member name: " + member.getName());
        });
    }


    private static void subQuery2(EntityManager em) {
        String query = "SELECT m FROM Member m WHERE (SELECT COUNT(o) FROM Order o WHERE m = o.member) = 0";
        em.createQuery(query, Member.class).getResultList().forEach(member -> {
            System.out.println("member name: " + member.getName());
        });
    }

    private static void subQuery1(EntityManager em) {
        String query = "SELECT m FROM Member m WHERE m.age > (SELECT AVG(m2.age) FROM Member m2)";
        em.createQuery(query, Member.class).getResultList().forEach(member -> {
            System.out.println("member name: " + member.getName());
        });
    }


}
