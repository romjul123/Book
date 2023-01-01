package com.kh.ymk;

import java.util.List;
import java.util.Scanner;

public class BookView {
	public int mainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("====== 도서 관리 프로그램 ======");
		System.out.println("1. 전체 목록 조회");
		System.out.println("2. 도서명으로 조회");
		System.out.println("3. 작가명으로 조회");
		System.out.println("4. 도서 등록");
		System.out.println("5. 도서 정보 수정");
		System.out.println("6. 도서 목록 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("메뉴 선택: ");
		int choice = sc.nextInt();
		return choice;
	}
	
	public void showAll(List<Book> bList) {
		System.out.println("====== 전체 목록 조회 ======");
		for(Book bOne : bList) {
			System.out.print("등록번호 : " + bOne.getBookNumber());
			System.out.print(", 도서명 : " + bOne.getBookName());
			System.out.print(", 작가명 : " + bOne.getWriterName());
			System.out.print(", 출판사 : " + bOne.getPublisher());
			System.out.print(", 가격 : " + bOne.getPrice());
			System.out.println(", 장르 : " + bOne.getGenre());
		}
	}
	
	public void showOne(Book book) {
		System.out.println(book.toString());
		System.out.print("등록번호 : " + book.getBookNumber());
		System.out.print(", 도서명 : " + book.getBookName());
		System.out.print(",작가명 : " + book.getWriterName());
		System.out.print(", 출판사 : " + book.getPublisher());
		System.out.print(", 가격 : " + book.getPrice());
		System.out.println(", 장르 : " + book.getGenre());
	}
	
	public Book inputBook() {
		Scanner sc = new Scanner(System.in);
		System.out.println("====== 도서 정보 입력 ======");
		System.out.println("등록번호 : ");
		int bookNumber = sc.nextInt();
		System.out.println("도서명 : ");
		sc.nextLine();
		String bookName = sc.nextLine();
		System.out.println("작가명 : ");
		String writerName = sc.nextLine();
		System.out.println("출판사 : ");
		String publisher = sc.next();
		System.out.println("가격 : ");
		int price = sc.nextInt();
		System.out.println("장르 : ");
		String genre = sc.next();
		Book book = new Book(bookNumber, bookName, writerName, publisher, price, genre);
		return book;
	}
	
//	public int inputBookNumber(String message) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println(message + "할 등록번호 입력 : ");
//		int bookNumber = sc.nextInt();
//		return bookNumber;
//	}
	
	public String inputBookName(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.println(message + "할 도서명 입력 : ");
		String bookName = sc.next();
		return bookName;
	}
	
	public String inputWriterName(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.println(message + "할 작가명 입력 : ");
		String writerName = sc.next();
		return writerName;
	}
	
	public Book modifyBook(Book book) {
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 작가명 입력 : ");
		String writerName = sc.next();
		System.out.println("수정할 출판사명 입력 : ");
		sc.nextLine();
		String publisher = sc.nextLine();
		System.out.println("수정할 가격 입력 : ");
		int price = sc.nextInt();
		System.out.println("수정할 장르 입력 : ");
		String genre = sc.next();
		book.setWriterName(writerName);
		book.setPublisher(publisher);
		book.setPrice(price);
		book.setGenre(genre);
		return book;
	}
	
	public void printMessage(String msg) {
		System.out.println(msg);
	}
	
	public void displaySuccess(String message) {
		System.out.println("[성공] : " + message);
	}
	
	public void displayError(String message) {
		System.out.println("[실패] : " + message);
	}
}
