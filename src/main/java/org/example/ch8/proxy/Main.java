package org.example.ch8.proxy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        printUserAndTeam(em);
        printMember(em);
        Member proxyMember = em.getReference(Member.class, "cho");
        Member member = em.find(Member.class, "cho");

        emf.close();
    }

    private static void printMember(EntityManager em) {
        Member member = em.find(Member.class, "cho");
        System.out.println("member's name = " + member.getUsername());
    }

    private static void printUserAndTeam(EntityManager em) {
        Member member = em.find(Member.class, "cho");
        System.out.println("member's name = " + member.getUsername());
        System.out.println("team's name = " + member.getTeam().getName());
    }

}
