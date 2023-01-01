package com.kh.ymk;

import java.util.List;

public class BookController {
	/**
	 * 전체 목록 조회
	 * @return
	 */
	public List<Book> printAll() {
		BookDAO bDao = new BookDAO();
		List<Book> bList = bDao.selectAll();
		return bList;
	}
	/**
	 * 도서명으로 조회
	 */
	public List<Book> printAllByBook(String bookName) {
		BookDAO bDao = new BookDAO();
		List<Book> bList = bDao.selectAllByBook(bookName);
		return bList;
	}
	/**
	 * 작가명으로 조회
	 */
	public Book printOneByWriter(String writerName) {
		BookDAO bDao = new BookDAO();
		Book book = bDao.selectOneByWriter(writerName);
		return book;
	}
	
	public Book printOneByBook(String bookName) {
		BookDAO bDao = new BookDAO();
		Book book = bDao.selectOneByBook(bookName);
		return book;
	}
	/**
	 * 도서 등록
	 * @param book
	 * @return
	 */
	public int registerBook(Book book) {
		BookDAO bDao = new BookDAO();
		int result = bDao.insertBook(book);
		return result;
	}
	/**
	 * 도서 목록 삭제
	 * @param bookName
	 * @return
	 */
	public int removeBook(String bookName) {
		BookDAO bDao = new BookDAO();
		int result = bDao.deleteBook(bookName);
		return result;
	}
	/**
	 * 도서 정보 수정
	 * @param book
	 * @return
	 */
	public int modifyBook(Book book) {
		BookDAO bDao = new BookDAO();
		int result = bDao.updateBook(book);
		return result;
	}
}
