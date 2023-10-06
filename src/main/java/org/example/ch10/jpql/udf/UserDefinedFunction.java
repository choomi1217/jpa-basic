package org.example.ch10.jpql.udf;

import org.example.ch10.jpql.entity.Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserDefinedFunction {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();

        String query = "SELECT FUNCTION('concat_name' , it.name) FROM Item it";
        List<String> resultList = em.createQuery(query, String.class).getResultList();
        resultList.forEach(System.out::println);
    }
}
