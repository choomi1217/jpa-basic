package org.example.ch10.jpql.select;

import org.example.ch10.jpql.entity.Member;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m WHERE m.name = :name", Member.class);
        query.setParameter("name", "kim");
        List<Member> resultList = query.getResultList();
        resultList.forEach(member -> System.out.println(member.getName()));

    }

    private static void basic3(EntityManager em) {
    Query query = em.createQuery("SELECT m.id, m.name FROM Member m");
    List resultList = query.getResultList();
    resultList.forEach(o -> {
        Object[] object = (Object[]) o;
        System.out.println("id: " + object[0]);
        System.out.println("name: " + object[1]);
    });
    }

    /**
     * SELECT m.name FROM Member m where m.age > 20
     * */
    private static void basic2(EntityManager em) {
        TypedQuery<String> query = em.createQuery("SELECT m.name FROM Member m where m.age > 20", String.class);
        List<String> resultList = query.getResultList();
        resultList.forEach(System.out::println);
    }

    /**
     * SELECT m FROM Member m
     * */
    private static void basic(EntityManager em) {
        TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m", Member.class);
        List<Member> resultList = query.getResultList();
        resultList.forEach(member -> System.out.println(member.getName()));
    }
}
