package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
//@Api(tags = "Book API")
public class BookController {
    @Autowired
    private BookServiceImpl bookService;
    @PostMapping
    //@ApiOperation("Create a new book")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookService.createBook(book);
        return ResponseEntity.ok(createdBook);
    }

    @GetMapping("/name/{name}")
    //@ApiOperation("Get books by name")
    public ResponseEntity<List<Book>> getBooksByName(@PathVariable String name) {
        List<Book> books = bookService.getBooksByName(name);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/author/{author}")
    //@ApiOperation("Get books by author")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable String author) {
        List<Book> books = bookService.getBooksByAuthor(author);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/allbooks")
    //@ApiOperation("Get all books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/publisher/{publisher}")
    //@ApiOperation("Get books by publisher")
    public ResponseEntity<List<Book>> getBooksByPublisher(@PathVariable String publisher) {
        List<Book> books = bookService.getBooksByPublisher(publisher);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/discount/{discount}")
    //@ApiOperation("Get books by discount")
    public ResponseEntity<List<Book>> getBooksByDiscount(@PathVariable int discount) {
        List<Book> books = bookService.getBooksByDiscount(discount);
        return ResponseEntity.ok(books);
    }

    @PutMapping("/{id}")
    //@ApiOperation("Update a book by ID")
    public ResponseEntity<Book> updateBook(@PathVariable Integer id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    //@ApiOperation("Delete a book by ID")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book deleted successfully");
    }

    @GetMapping("/sort/price/asc")
    //@ApiOperation("Get books sorted by price in ascending order")
    public ResponseEntity<List<Book>> getBooksSortedByPriceAsc() {
        List<Book> books = bookService.getBooksSortedByPriceAsc();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/sort/price/desc")
    //@ApiOperation("Get books sorted by price in descending order")
    public ResponseEntity<List<Book>> getBooksSortedByPriceDesc() {
        List<Book> books = bookService.getBooksSortedByPriceDesc();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/orders/{status}")
    //@ApiOperation("Get books by order status sorted by order date in ascending order")
    public ResponseEntity<List<Book>> getBooksByOrderStatusSortedByOrderDateAsc(@PathVariable String status) {
        List<Book> books = bookService.getBooksByOrderStatusSortedByOrderDateAsc(status);
        return ResponseEntity.ok(books);
    }

    @PostMapping("/order/{bookId}")
    //@ApiOperation("Order a book by ID")
    public ResponseEntity<Book> orderBook(@PathVariable("bookId") Integer bookId) {
        Book orderedBook = bookService.orderBook(bookId);
        return ResponseEntity.ok(orderedBook);
    }
}
