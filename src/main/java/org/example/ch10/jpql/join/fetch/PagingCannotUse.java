package org.example.ch10.jpql.join.fetch;

import org.example.ch10.jpql.entity.Member;
import org.example.ch10.jpql.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * 컬렉션을 페치조인하면 페이징 API를 사용할 수 없다.
 * */
public class PagingCannotUse {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT m FROM Member m JOIN FETCH m.orders";

        List<Member> resultList = em.createQuery(query, Member.class)
                .setFirstResult(0)
                .setMaxResults(5)
                .getResultList();

        System.out.println(resultList.size());
        for (Member member : resultList) {
            System.out.println("member name: " + member.getName());
            List<Order> orders = member.getOrders();
            for (Order order : orders) {
                System.out.println("order id: " + order.getId());
            }
        }

    }
}
