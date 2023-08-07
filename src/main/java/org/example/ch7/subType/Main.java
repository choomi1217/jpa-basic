package org.example.ch7.subType;

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
        album.setName("Album 1");
        album.setPrice(1000);
        album.setArtist("Artist 1");
        em.persist(album);

        Book book = new Book();
        book.setName("Book 1");
        book.setPrice(2000);
        book.setAuthor("Author 1");
        book.setIsbn("ISBN 1");
        em.persist(book);

        Movie movie = new Movie();
        movie.setName("Movie 1");
        movie.setPrice(3000);
        movie.setActor("Actor 1");
        movie.setDirector("Director 1");
        em.persist(movie);

        tx.commit();
        emf.close();

    }
}
