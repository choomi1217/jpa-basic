package org.example.ch6.practice;

import org.example.ch6.practice.entity.*;
import org.example.ch6.practice.service.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
        Item note = itemService.save(new Item("note", 1000, 10), lineNote);

        //상품구매
        Delivery delivery = deliveryService.save(new Delivery(member.getCity(), member.getStreet(), member.getZipcode()));
        Purchase purchase = purchaseService.save(new Purchase(member, delivery));
        purchaseService.save(new PurchaseItem(purchase, note, 1));

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
        //회원 주문내역 별 상품 카테고리 조회
        note.getCategoryItem().forEach(categoryItem -> {
            System.out.println("category : " + categoryItem.getCategory().getName());
        });


    }
}
