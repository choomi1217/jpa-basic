package org.example.ch4;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter
@TableGenerator(
        name = "TABLE_USER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "USER_SEQ", allocationSize = 1
)
public class TableUser {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_USER_SEQ_GENERATOR")
    private Long id;
    private String username;
    private Integer age;
    private RoleType roleType;
    private String description;
}
