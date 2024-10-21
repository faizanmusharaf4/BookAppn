package com.example.demo;

import java.util.List;

public interface BookService {
	
	Book createBook(Book book);    //return type, name, type like string(1st), name
	
	List<Book> getBooksByName(String name);
	
	List<Book> getBooksByAuthor(String author);
	
	List<Book> getBooksByPublisher(String publisher);
	
	List<Book> getBooksByDiscount(int discount);
	
	Book updateBook(Integer id, Book book);
	
	void deleteBook(Integer id);
	
	List<Book> getAllBooks();
	
	List<Book> getBooksSortedByPriceAsc();
	
	List<Book> getBooksSortedByPriceDesc();
	
	List<Book> getBooksByOrderStatusSortedByOrderDateAsc(String status);
	
	Book orderBook(Integer bookId);

}
