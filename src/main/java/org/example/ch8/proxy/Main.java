package org.example.ch8.proxy;

import org.hibernate.LazyInitializationException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        usefulAssociationSetting(em);
        proxyNotInitialized(em);
        initializeDetachEntity(em);
        isProxyInitialized(em, emf);

        emf.close();
    }

    /**
     * 연관관계를 설정할 때 유용하게 사용할 수 있습니다.
     * */
    private static void usefulAssociationSetting(EntityManager em) {
        Member member = em.find(Member.class, "cho");
        Team proxyTeam = em.getReference(Team.class, "A");
        member.setTeam(proxyTeam);
    }

    /**
     * 식별자가 보관되고 초기화 되지 않음.
     * */
    private static void proxyNotInitialized(EntityManager em) {
        proxyNotInitialized(em);
        Team teamA = em.getReference(Team.class, "A");
        System.out.println(teamA.getId());
    }

    /**
     * 프록시의 초기화 여부를 판단 할 수 있습니다.
     * */
    private static void isProxyInitialized(EntityManager em, EntityManagerFactory emf) {
        Member proxyMember = em.getReference(Member.class, "cho");
        System.out.println("isInitialized = " + emf.getPersistenceUnitUtil().isLoaded(proxyMember));
        proxyMember.getUsername();
        System.out.println("isInitialized = " + emf.getPersistenceUnitUtil().isLoaded(proxyMember));

    }

    /**
     * 준영속 상태가 된 프록시 객체에 초기화를 요청하면 에러가납니다.
     * */
    private static void initializeDetachEntity(EntityManager em) {
        Member proxyMember = em.getReference(Member.class, "cho");
        em.close();
        try {
            proxyMember.getUsername();
        }catch (LazyInitializationException e) {
            System.out.println("LazyInitializationException");
        }
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
