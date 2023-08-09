package org.example.ch7.composeKey.discriminator.oneToOne;

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

        Board board = new Board();
        board.setTitle("board1");
        em.persist(board);

        BoardDetail boardDetail = new BoardDetail();
        boardDetail.setContent("board1 - content1");
        boardDetail.setBoard(board);
        em.persist(boardDetail);

        tx.commit();
        em.clear();

        Board findBoard = em.find(Board.class, board.getId());
        BoardDetail findBoardDetail = em.find(BoardDetail.class, board.getId());

        System.out.println("findBoard = " + findBoard.getTitle());
        System.out.println("findBoardDetail = " + findBoardDetail.getContent());
    }
}
