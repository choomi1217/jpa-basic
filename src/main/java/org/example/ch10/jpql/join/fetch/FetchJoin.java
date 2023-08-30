package org.example.ch10.jpql.join.fetch;

import org.example.ch10.jpql.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class FetchJoin {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT m FROM Member m JOIN FETCH m.team";

        List<Member> resultList = em.createQuery(query, Member.class)
                .getResultList();

        resultList.forEach(m -> {
            System.out.println("member name: " + m.getName());
            System.out.println("team name: " + m.getTeam().getName());
            System.out.println("--------------------");
        });
    }
}
