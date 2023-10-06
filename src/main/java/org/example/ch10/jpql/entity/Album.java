package org.example.ch10.jpql.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ALBUM")
@Getter @Setter
public class Album extends Item{
    private String artist;
}
