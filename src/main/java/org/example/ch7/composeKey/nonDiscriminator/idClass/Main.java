package org.example.ch7.composeKey.nonDiscriminator.idClass;

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
        parent.setId1("1");
        parent.setId2("2");
        parent.setName("parentName");
        em.persist(parent);

        Child child = new Child();
        child.setParent(parent);
        child.setName("childName");
        em.persist(child);

        tx.commit();
        em.clear();

        ParentId parentId = new ParentId();
        parentId.setId1("1");
        parentId.setId2("2");
        Parent findParent = em.find(Parent.class, parentId);
        System.out.println("findParent id1 = " + findParent.getId1());
        System.out.println("findParent id2 = " + findParent.getId2());
        System.out.println("findParent name = " + findParent.getName());

        System.out.println("-----------------------");
        System.out.println("child's id = " + child.getId());
        System.out.println("child's name = " + child.getName());
        System.out.println("child's parent id1 = " + child.getParent().getId1());
        System.out.println("child's parent id2 = " + child.getParent().getId2());
        System.out.println("child's parent name = " + child.getParent().getName());

    }
}
