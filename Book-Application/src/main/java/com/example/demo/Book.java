package com.example.demo;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Slf4j
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String author;
	private String publisher;
	private String edition;
	private int discount;
	private int stock;
	private String orderStatus;
	private Long orderId;
	private LocalDate orderDate;
	private double price;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Book that = (Book) o;
		return Objects.equals(name, that.name) && Objects.equals(author, that.author);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, author);
	}
}




//	public Book() {
//		super();
//	}
//
//	@Override
//	public String toString() {
//		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", publisher=" + publisher + ", edition="
//				+ edition + ", discount=" + discount + ", stock=" + stock + ", orderStatus=" + orderStatus
//				+ ", orderId=" + orderId + ", orderDate=" + orderDate + ", price=" + price + "]";
//	}


//	public Book(
//	) {
//	super();
//	this.id = id;
//	this.name = name;
//	this.author = author;
//	this.publisher = publisher;
//	this.edition = edition;
//	this.discount = discount;
//	this.stock = stock;
//	this.orderStatus = orderStatus;
//	this.orderId = orderId;
//	this.orderDate = orderDate;
//	this.price = price;
//}

//	public long getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(String author) {
//		this.author = author;
//	}
//
//	public String getPublisher() {
//		return publisher;
//	}
//
//	public void setPublisher(String publisher) {
//		this.publisher = publisher;
//	}
//
//	public String getEdition() {
//		return edition;
//	}
//
//	public void setEdition(String edition) {
//		this.edition = edition;
//	}
//
//	public int getDiscount() {
//		return discount;
//	}
//
//	public void setDiscount(int discount) {
//		this.discount = discount;
//	}
//
//	public int getStock() {
//		return stock;
//	}
//
//	public void setStock(int stock) {
//		this.stock = stock;
//	}
//
//	public String getOrderStatus() {
//		return orderStatus;
//	}
//
//	public void setOrderStatus(String orderStatus) {
//		this.orderStatus = orderStatus;
//	}
//
//	public Long getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(Long orderId) {
//		this.orderId = orderId;
//	}
//
//	public LocalDate getOrderDate() {
//		return orderDate;
//	}
//
//	public void setOrderDate(LocalDate orderDate) {
//		this.orderDate = orderDate;
//	}
//
//	public double getPrice() {
//		return price;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}
//}
