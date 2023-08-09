package org.example.ch7.composeKey.discriminator.embeddedId;

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
        parent.setId("parentId");
        parent.setName("parent");
        em.persist(parent);

        Child child = new Child();
        child.setId(new ChildId(parent.getId(), "childId"));
        child.setName("child");
        child.setParent(parent);
        em.persist(child);

        GrandChild grandChild = new GrandChild();
        grandChild.setId(new GrandChildId(child.getId(), "grandChildId"));
        grandChild.setName("grandChild");
        grandChild.setChild(child);
        em.persist(grandChild);

        tx.commit();
        em.clear();

        Parent findParent = em.find(Parent.class, parent.getId());
        Child child1 = em.find(Child.class, child.getId());
        GrandChild grandChild1 = em.find(GrandChild.class, grandChild.getId());

        System.out.println("-----------------");
        System.out.println("parent = " + findParent.getName());
        System.out.println("-----------------");
        System.out.println("child = " + child1.getName());
        System.out.println("child's parent = " + child1.getParent().getName());
        System.out.println("-----------------");
        System.out.println("grandChild = " + grandChild1.getName());
        System.out.println("grandChild's parent = " + grandChild1.getChild().getName());
        System.out.println("grandChild's grandParent = " + grandChild1.getChild().getParent().getName());

    }
}
