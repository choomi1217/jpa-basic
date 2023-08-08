package org.example.ch7.subType.singleTableStrategy;

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
        Album album = new Album();
        album.setName("album");
        album.setPrice(10000);
        album.setArtist("artist");
        em.persist(album);

        Book book = new Book();
        book.setName("book");
        book.setPrice(20000);
        book.setAuthor("author");
        em.persist(book);

        Movie movie = new Movie();
        movie.setName("movie");
        movie.setPrice(30000);
        movie.setDirector("director");
        em.persist(movie);

        tx.commit();
        emf.close();

    }
}
