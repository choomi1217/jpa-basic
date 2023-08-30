package org.example.ch10.jpql.join.fetch;

import org.example.ch10.jpql.entity.Member;
import org.example.ch10.jpql.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * 페치조인한 엔티티에 별칭
 * */
public class FetchAlias {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT t FROM Team t JOIN FETCH t.members m WHERE t.name = :names AND m.name = :memberName";
        List<Team> resultList = em.createQuery(query, Team.class)
                .setParameter("names", "teamA")
                .setParameter("memberName", "hong")
                .getResultList();

        resultList.forEach(t -> {
            System.out.println("--------------------");
            System.out.println("team name: " + t.getName());
            for (Member member : t.getMembers()) {
                System.out.println("member name: " + member.getName());
            }
        });
    }
}
