package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

	List<Book> findByName(String name);

    List<Book> findByAuthor(String author);

    List<Book> findByPublisher(String publisher);

    List<Book> findByDiscount(int discount);

    List<Book> findAllByOrderByPriceAsc();

    List<Book> findAllByOrderByPriceDesc();

    List<Book> findByOrderStatusOrderByOrderDateAsc(String status);
}