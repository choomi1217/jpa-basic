package org.example.practice;

import org.example.practice.entity.*;
import org.example.practice.service.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
    private static MemberService memberService = new MemberService(emf);
    private static CategoryService categoryService = new CategoryService(emf);
    private static ItemService itemService = new ItemService(emf);
    private static DeliveryService deliveryService = new DeliveryService(emf);
    private static PurchaseService purchaseService = new PurchaseService(emf);

    public static void main(String[] args) {

        //회원등록
        Member member = memberService.save(new Member("cho", "서울", "서초구", "123-123"));

        //카테고리등록
        Category noteCategory = categoryService.save(new Category("note"));
        Category lineNote = categoryService.save(new Category(noteCategory.getId(), "lineNote"));

        //상품등록
        Album album = new Album();
        album.setCreatedAt(new Date());
        album.setName("album");
        album.setPrice(10000);
        album.setStockQuantity(10);
        album.setArtist("홍길동");

        Book book = new Book();
        book.setCreatedAt(new Date());
        book.setName("book");
        book.setPrice(30000);
        book.setStockQuantity(30);
        book.setAuthor("이영희");
        book.setIsbn("123-123-123");

        Movie movie = new Movie();
        movie.setCreatedAt(new Date());
        movie.setName("movie");
        movie.setPrice(20000);
        movie.setStockQuantity(20);
        movie.setDirector("김철수");
        movie.setActor("이영희");

        itemService.save(album, lineNote);
        itemService.save(book, lineNote);
        itemService.save(movie, lineNote);

        //상품구매
        Delivery delivery = deliveryService.save(new Delivery(member.getCity(), member.getStreet(), member.getZipcode()));
        Purchase purchase = purchaseService.save(new Purchase(member, delivery));
        purchaseService.save(new PurchaseItem(purchase, album, 1));

        //회원조회
        Member cho = memberService.find(member.getId());

        //회원 주문내역 조회
        System.out.println("----- " + cho.getName() + " 회원님의 주문내역 -----");
        cho.getPurchases().forEach(userPurchase -> {
            System.out.println("* 주문번호 : " + userPurchase.getId());
            System.out.println("* 주문상태 : " + userPurchase.getStatus());
            System.out.println("* 주문날짜 : " + userPurchase.getPurchaseDate());
            userPurchase.getPurchaseItems().forEach(purchaseItem -> {
                System.out.println("* 상품명 : " + purchaseItem.getItem().getName());
                purchaseItem.getItem().getCategoryItem().forEach(categoryItem -> {
                    System.out.println("* 상품 카테고리 : " + categoryItem.getCategory().getName());
                });
                System.out.println("* 상품가격 : " + purchaseItem.getItem().getPrice());
                System.out.println("* 상품수량 : " + purchaseItem.getCount());
                System.out.println("* 총 가격 : " + purchaseItem.getPurchasePrice());
            });
            System.out.println("-----");
        });

    }
}
