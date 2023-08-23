package org.example.practice.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("Movie")
public class Movie extends Item {
    private String director;
    private String actor;

    public Movie() { }

    public Movie(String name, int price, int stockQuantity, String director, String actor, Date date) {
        super(name, price, stockQuantity, date);
        this.director = director;
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
