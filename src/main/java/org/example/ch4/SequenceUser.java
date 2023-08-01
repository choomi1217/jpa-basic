package org.example.ch4;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity @Getter @Setter
@Table(name = "sequence_user")
@SequenceGenerator(
        name = "USER_SEQ_GENERATOR",
        sequenceName = "SEQUENCE_USER_SEQ",
        initialValue = 1, allocationSize = 1
)
public class SequenceUser {
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
