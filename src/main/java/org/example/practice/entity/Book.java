package org.example.practice.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;

@Entity
@DiscriminatorValue("Book")
@PrimaryKeyJoinColumn(name = "BOOK_ID")
public class Book extends Item {
    private String author;
    private String isbn;

    public Book(String name, int price, int stockQuantity, String author, String isbn , Date date) {
        super(name, price, stockQuantity, date);
        this.author = author;
        this.isbn = isbn;
    }

    public Book() { }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
