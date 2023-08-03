package org.example.ch6.manyToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Team {

    @Id @GeneratedValue
    private Long id;
    private String name;
}
