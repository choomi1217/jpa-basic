package org.example.ch7.composeKey.discriminator.idClass;

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
        parent.setName("parentName1");
        em.persist(parent);

        Child child = new Child();
        child.setName("childName1");
        child.setParent(parent);
        em.persist(child);

        GrandChild grandChild = new GrandChild();
        grandChild.setName("grandChildName1");
        grandChild.setChild(child);
        em.persist(grandChild);
        tx.commit();
        em.clear();

        Parent findParent = em.find(Parent.class, parent.getId());

        ChildId childId = new ChildId();
        childId.setParent(findParent.getId());
        childId.setChildId(child.getChildId());
        Child findChild = em.find(Child.class, childId);

        GrandChildId grandChildId = new GrandChildId();
        grandChildId.setChild(childId);
        grandChildId.setGrandChildId(grandChild.getGrandChildId());
        GrandChild findGrandChild = em.find(GrandChild.class, grandChildId);

        System.out.println("findParent = " + findParent.getName());

        System.out.println("-----------------");
        System.out.println("findChild = " + findChild.getName());
        System.out.println("child's parent = " + findChild.getParent().getName());

        System.out.println("-----------------");
        System.out.println("findGrandChild = " + findGrandChild.getName());
        System.out.println("grandChild's child = " + findGrandChild.getChild().getName());
        System.out.println("grandChild's parent = " + findGrandChild.getChild().getParent().getName());

    }
}
