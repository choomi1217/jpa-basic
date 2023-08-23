package org.example.practice.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("Album")
public class Album extends Item {
    private String artist;

    public Album() { }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Album(String artist) {
        this.artist = artist;
    }

    public Album(String name, int price, int stockQuantity, String artist, Date date) {
        super(name, price, stockQuantity, date);
        this.artist = artist;
    }
}
