package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class JunitTestCases {
	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private BookServiceImpl bookService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testCreateBook() {

		Book book = new Book(1, "max", "pratoon", "grty", "first", 3, 5, "ordered", 243l, null, 0);

		when(bookRepository.save(book)).thenReturn(book);

		Book createdBook = bookService.createBook(book);

		assertNotNull(createdBook);
		assertEquals(book.getName(), createdBook.getName());
		assertEquals(book.getAuthor(), createdBook.getAuthor());
		assertEquals(book.getPublisher(), createdBook.getPublisher());
		assertEquals(book.getEdition(), createdBook.getEdition());
		assertEquals(book.getDiscount(), createdBook.getDiscount());
		assertEquals(book.getStock(), createdBook.getStock());
		assertEquals(book.getPrice(), createdBook.getPrice());
		assertNull(createdBook.getOrderDate());

	}

	@Test
	void testGetBooksByName() {
		ArrayList<Book> books = new ArrayList<>();
		books.add(new Book(1, "john", "gary", "penguin", "first", 3, 5, "ordered", 2l, null, 3445));

		when(bookRepository.findByName("john")).thenReturn(books);

		List<Book> foundBooks = bookService.getBooksByName("john");
		System.out.println(foundBooks);

		assertNotNull(foundBooks);
		assertEquals(1, foundBooks.size());
		assertEquals("john", foundBooks.get(0).getName());
		assertEquals("gary", foundBooks.get(0).getAuthor());
		assertEquals("penguin", foundBooks.get(0).getPublisher());
		assertEquals("first", foundBooks.get(0).getEdition());
		assertEquals(3, foundBooks.get(0).getDiscount());
		assertEquals(5, foundBooks.get(0).getStock());
		assertEquals(3445, foundBooks.get(0).getPrice());

	}

	@Test
	void testGetBooksByDiscount() {
		ArrayList<Book> books = new ArrayList<>();
		books.add(new Book(1, "john", "gary", "penguin", "first", 10, 5, "ordered", 2l, null, 3445));
		books.add(new Book(2, "jessy", "carl", "peterson", "second", 10, 57, "ordered", 22l, null, 5453));

		when(bookRepository.findByDiscount(10)).thenReturn(books);

		List<Book> foundBooks = bookService.getBooksByDiscount(10);
		System.out.println(foundBooks);

		assertNotNull(foundBooks);
		assertEquals(2, foundBooks.size());
		assertEquals("john", foundBooks.get(0).getName());
		assertEquals("gary", foundBooks.get(0).getAuthor());
		assertEquals("penguin", foundBooks.get(0).getPublisher());
		assertEquals("first", foundBooks.get(0).getEdition());
		assertEquals(10, foundBooks.get(0).getDiscount());
		assertEquals(5, foundBooks.get(0).getStock());
		assertEquals(3445, foundBooks.get(0).getPrice());

	}

	/*@Test
	public void getBooksByDiscount_InvalidDiscount() {
		int discount = 30;

		ArrayList<Book> books = new ArrayList<>();
		books.add(new Book(1, "john", "gary", "penguin", "first", 20, 5, "ordered", 2l, null, 3445));

		when(bookRepository.findByDiscount(20)).thenReturn(books);

		List<Book> foundBooks = bookService.getBooksByDiscount(20);
		System.out.println(foundBooks);

		assertNotEquals(20, foundBooks.get(0).getDiscount());

		Assertions.assertThrows(RuntimeException.class, () -> {
			bookService.getBooksByDiscount(discount);
		});
	}*/

}
