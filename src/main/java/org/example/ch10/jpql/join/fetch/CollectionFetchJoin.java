package org.example.ch10.jpql.join.fetch;

import org.example.ch10.jpql.entity.Member;
import org.example.ch10.jpql.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CollectionFetchJoin {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT t FROM Team t JOIN FETCH t.members WHERE t.name in (:names)";

        List<Team> resultList = em.createQuery(query, Team.class).setParameter("names", List.of("teamA", "teamB") ).getResultList();

        resultList.forEach(t -> {
            System.out.println("--------------------");
            System.out.println("team name: " + t.getName());
            List<Member> members = t.getMembers();
            members.forEach(m -> {
                System.out.println("member name: " + m.getName());
            });
            System.out.println("--------------------");
        });

        System.out.println(resultList.get(0) == resultList.get(1));


    }
}
