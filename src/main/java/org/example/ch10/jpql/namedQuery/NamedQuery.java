package org.example.ch10.jpql.namedQuery;

import org.example.ch10.jpql.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class NamedQuery {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();

        List<Member> resultList1 = em.createNamedQuery("Member.findByName", Member.class)
                .setParameter("username", "cho")
                .getResultList();

        resultList1.forEach(member -> {
            System.out.println(member.getId() + "번 " + member.getName());
        });

        List<Member> resultList2 = em.createNamedQuery("Member.findByCity", Member.class)
                .setParameter("cityName", "seoul")
                .getResultList();
        resultList2.forEach(member -> {
            System.out.println(member.getId() + "번 " + member.getName() + ", 사는곳 : " + member.getAddress().getCity());
        });
    }
}
