package com.example.demo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;

	public Book createBook(Book book) {
		if (bookRepository.findAll().contains(book)) {
			throw new IllegalArgumentException("Duplicate book entry not allowed");
		} else {
			return bookRepository.save(book);
		}
	}

	public List<Book> getBooksByName(String name) {
		return bookRepository.findByName(name);
	}

	public List<Book> getBooksByAuthor(String author) {
		return bookRepository.findByAuthor(author);
	}

	public List<Book> getBooksByPublisher(String publisher) {
		return bookRepository.findByPublisher(publisher);
	}

	public List<Book> getBooksByDiscount(int discount) {
		List<Book> books;
		if (discount <= 10) {
			books = bookRepository.findByDiscount(10);
			// throws new RuntimeException("Max discount available is 20%. Please search
			// with
			// a valid discount.");
		} else if (discount < 15) {
			books = bookRepository.findByDiscount(15);
		} else if (discount > 15 && discount < 20) {
			books = bookRepository.findByDiscount(20);
			// throw new RuntimeException("No books available with 30% discount. Please
			// search with a valid discount.");
		} else {
			throw new RuntimeException("Max discount available is 20%. Please search with a valid discount.");
		}
		return books;
	}

	public Book updateBook(Integer id, Book book) {
		Book existingBook = bookRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
		existingBook.setName(book.getName());

		existingBook.setEdition(book.getEdition());

		existingBook.setDiscount(book.getDiscount());

		existingBook.setStock(book.getStock());

		existingBook.setPrice(book.getPrice());

		return bookRepository.save(existingBook);
	}
	
	public void deleteBook(Integer id) {

		bookRepository.deleteById(id);
	}

	public List<Book> getAllBooks() {

		return bookRepository.findAll();
	}

	public List<Book> getBooksSortedByPriceAsc() {
		return bookRepository.findAllByOrderByPriceAsc();
	}

	public List<Book> getBooksSortedByPriceDesc() {
		return bookRepository.findAllByOrderByPriceDesc();
	}

	public List<Book> getBooksByOrderStatusSortedByOrderDateAsc(String status) {
		return bookRepository.findByOrderStatusOrderByOrderDateAsc(status);
	}

	public Book orderBook(Integer bookId) {

		Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));

		if (book.getOrderStatus() == null) {
			book.setOrderStatus(OrderStatus.ORDERED.name());
			book.setOrderDate(LocalDate.now());
			book.setOrderId(book.getOrderId());

			return bookRepository.save(book);
		} else {
			throw new RuntimeException("Book with id " + bookId + " is already ordered.");
		}
	}

}
