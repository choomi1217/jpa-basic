package org.example.ch9.embeddedValue.association;

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

        Member member = new Member();
        member.setName("John Doe");
        Address address = new Address();
        address.setCity("Seoul");
        address.setStreet("Gangnam Street");
        Zipcode zipcode = new Zipcode();
        zipcode.setZip("122");
        zipcode.setPlusFour("6789");
        address.setZip(zipcode);
        member.setAddress(address);
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setAreaCode("212");
        phoneNumber.setLocalNumber("555-1234");
        PhoneServiceProvider provider = new PhoneServiceProvider();
        provider.setName("KT");
        em.persist(provider);
        phoneNumber.setProvider(provider);
        member.setPhoneNumber(phoneNumber);
        em.persist(member);

        tx.commit();
        em.close();
        emf.close();

    }
}
