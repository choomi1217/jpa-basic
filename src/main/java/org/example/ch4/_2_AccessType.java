package org.example.ch4;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

public class _2_AccessType {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        AccessTypeFieldEntity fieldEntity = new AccessTypeFieldEntity();
        fieldEntity.setData1("data1");
        fieldEntity.setData2("data2");

        AccessTypePropertyEntity propertyEntity = new AccessTypePropertyEntity();
        propertyEntity.setData1("data1");
        propertyEntity.setData2("data2");

        AccessTypeFieldAndPropertyEntity fieldAndPropertyEntity = new AccessTypeFieldAndPropertyEntity();
        fieldAndPropertyEntity.setData1("data1");
        fieldAndPropertyEntity.setData2("data2");


        tx.begin();

        em.persist(fieldEntity);
        em.persist(propertyEntity);
        em.persist(fieldAndPropertyEntity);

        tx.commit();

        System.out.println("fieldEntity data1 : '" + fieldEntity.getData1() + "'" + ", data2 : '" + fieldEntity.getData2() + "'");
        System.out.println("propertyEntity data1 : '" + propertyEntity.getData1() + "'" + ", data2 : '" + propertyEntity.getData2() + "'");
        System.out.println("fieldAndPropertyEntity data : '" + fieldAndPropertyEntity.getData() + "'");

        emf.close();

    }

}

@Entity @Getter @Setter
@NoArgsConstructor
@Access(AccessType.FIELD)
class AccessTypeFieldEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String data1;
    private String data2;
}

@Entity @Getter @Setter
@NoArgsConstructor
@Access(AccessType.PROPERTY)
class AccessTypePropertyEntity {

    private Long id;

    private String data1;

    private String data2;

    private String data;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public String getData1() {
        return data1;
    }

    public String getData2() {
        return data2;
    }

    @Access(AccessType.PROPERTY)
    public String getData(){
        return data1 + data2;
    }

}

@Entity @Getter @Setter
@NoArgsConstructor
class AccessTypeFieldAndPropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private String data1;

    @Transient
    private String data2;

    @Transient
    private String data;

    @Access(AccessType.PROPERTY)
    public String getData() {
        return data1 + data2;
    }

}

