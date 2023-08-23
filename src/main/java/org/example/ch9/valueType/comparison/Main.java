package org.example.ch9.valueType.comparison;

import org.example.ch9.valueType.immutable.Address;
import org.example.ch9.valueType.immutable.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Member memberA = em.find(Member.class, 290L);
        Address memberAHomeAddress = memberA.getHomeAddress();

        Member memberB = em.find(Member.class, 291L);
        Address memberBHomeAddress = memberB.getHomeAddress();
        tx.commit();
        emf.close();
        System.out.println("동일성 비교 : " + (memberAHomeAddress == memberBHomeAddress));
        System.out.println("동등성 비교 : " + (memberAHomeAddress.equals(memberBHomeAddress)));
    }
}
