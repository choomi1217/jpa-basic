package org.example.ch7.composeKey.nonDiscriminator.embeddedId;

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
        Parent parent = new Parent();
        ParentId parentId = new ParentId();
        parentId.setId1("myId1");
        parentId.setId2("myId2");
        parent.setId(parentId);
        tx.commit();
        em.clear();

        Parent findParent = em.find(Parent.class, parentId);
        System.out.println("findParent = " + findParent.getId().getId1());
        System.out.println("findParent = " + findParent.getId().getId2());

        emf.close();
    }
}
