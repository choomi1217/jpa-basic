package org.example.ch8.loading.lazy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Member member = em.find(Member.class, "cho");
        System.out.println(member.getId()+"'s name : " + member.getUsername());

        Team team = member.getTeam();
        System.out.println(team.getClass());

        System.out.println("----- team -----");
        System.out.println("team name : " + team.getName());

    }
}
