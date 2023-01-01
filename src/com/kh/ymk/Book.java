package com.kh.ymk;

public class Book {
	
	private int bookNumber;
	private String bookName;
	private String writerName;
	private String publisher;
	private int price;
	private String genre;
	
	public Book() {}
	
	public Book(int bookNumber, String bookName, String writerName, String publisher, int price, String genre) {
		super();
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.writerName = writerName;
		this.publisher = publisher;
		this.price = price;
		this.genre = genre;
	}

	public int getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book [bookNumber=" + bookNumber + ", bookName=" + bookName + ", writerName=" + writerName
				+ ", publisher=" + publisher + ", price=" + price + ", genre=" + genre + "]";
	}
	
	

}
