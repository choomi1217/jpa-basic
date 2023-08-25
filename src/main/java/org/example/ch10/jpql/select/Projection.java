package org.example.ch10.jpql.select;

import org.example.ch10.jpql.dto.MemberDto;
import org.example.ch10.jpql.entity.Address;
import org.example.ch10.jpql.entity.Member;
import org.example.ch10.jpql.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Projection {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        entityTypeProjection(em);
        embeddedTypeProjection(em);
        scalarTypeProjection(em);
        manyTypeProjection(em);
        newProjection(em);
    }

    private static void newProjection(EntityManager em) {
        List<MemberDto> resultList = em.createQuery("SELECT new org.example.ch10.jpql.dto.MemberDto(m.name, m.age) FROM Member m", MemberDto.class).getResultList();
    }

    private static void manyTypeProjection(EntityManager em) {
        List<Object[]> resultList = em.createQuery("SELECT o.member, o.product, o.orderAmount FROM Order o").getResultList();
        resultList.forEach(objects -> {
            Member member = (Member) objects[0];
            System.out.println("member = " + member.getName());
            Product product = (Product) objects[1];
            System.out.println("product = " + product.getName());
            int orderAmount = (int) objects[2];
            System.out.println("orderAmount = " + orderAmount);
        });
    }

    private static void scalarTypeProjection(EntityManager em) {
        List<String> resultList = em.createQuery("SELECT m.name FROM Member m", String.class).getResultList();
        List<Double> ageAverage = em.createQuery("SELECT AVG(m.age) FROM Member m", Double.class).getResultList();
    }

    private static void embeddedTypeProjection(EntityManager em) {
        List<Address> resultList = em.createQuery("SELECT o.address FROM Order o", Address.class).getResultList();
    }

    private static void entityTypeProjection(EntityManager em) {
        List<Member> resultList = em.createQuery("SELECT m FROM Member m", Member.class).getResultList();
    }
}
