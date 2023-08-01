package org.example.ch4;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

public class _1_SequenceIncrement {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        IdentityUser identityUser = new IdentityUser();
        identityUser.setUsername("identityUser");
        identityUser.setAge(10);

        SequenceUser sequenceUser = new SequenceUser();
        sequenceUser.setUsername("sequenceUser");
        sequenceUser.setAge(20);

        TableUser tableUser = new TableUser();
        tableUser.setUsername("tableUser");
        tableUser.setAge(30);

        em.persist(identityUser);
        em.persist(sequenceUser);
        em.persist(tableUser);

        System.out.println("identityUser.getId() = " + identityUser.getId());
        System.out.println("sequenceUser.getId() = " + sequenceUser.getId());
        System.out.println("tableUser.getId() = " + tableUser.getId());

        tx.commit();
        emf.close();

    }

}
@Entity @Getter @Setter
@Table(name = "identity_user", uniqueConstraints = {@UniqueConstraint(
        name = "NAME_AGE_UNIQUE",
        columnNames = {"username", "age"}
)})
class IdentityUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

}

@Entity @Getter @Setter
@Table(name = "sequence_user")
@SequenceGenerator(
        name = "USER_SEQ_GENERATOR",
        sequenceName = "SEQUENCE_USER_SEQ",
        initialValue = 1, allocationSize = 1
)
class SequenceUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ_GENERATOR")
    private Long id;

    @Column(name = "name", nullable = false, length = 20)
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;
}

@Entity @Getter @Setter
@TableGenerator(
        name = "TABLE_USER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "USER_SEQ", allocationSize = 1
)
class TableUser {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_USER_SEQ_GENERATOR")
    private Long id;
    private String username;
    private Integer age;
    private RoleType roleType;
    private String description;
}

enum RoleType {
    ADMIN, USER
}
