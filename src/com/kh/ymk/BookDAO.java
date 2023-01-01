package com.kh.ymk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String USER = "BOOK";
	private final String PASSWORD = "BOOK";
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	
	public List<Book> selectAll() {
		String sql = "SELECT * FROM BOOK_TBL";
		Book book = null;
		List<Book> bList = null;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			bList = new ArrayList<Book>();
			while(rset.next()) {
				book = new Book();
				book.setBookNumber(rset.getInt("BOOK_NUMBER"));
				book.setBookName(rset.getString("BOOK_NAME"));
				book.setWriterName(rset.getString("WRITER_NAME"));
				book.setPublisher(rset.getString("PUBLISHER"));
				book.setPrice(rset.getInt("PRICE"));
				book.setGenre(rset.getString("GENRE"));
				bList.add(book);
			}
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bList;
	}
	
	public List<Book> selectAllByBook(String bookName) {
		List<Book> bList = null;
		Book book = null;
		String sql = "SELECT * FROM BOOK_TBL WHERE BOOK_NAME = '"+bookName+"'";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			bList = new ArrayList<Book>();
			while(rset.next()) {
				book = new Book();
				book.setBookNumber(rset.getInt("BOOK_NUMBER"));
				book.setBookName(rset.getString("BOOK_NAME"));
				book.setWriterName(rset.getString("WRITER_NAME"));
				book.setPublisher(rset.getString("PUBLISHER"));
				book.setPrice(rset.getInt("PRICE"));
				book.setGenre(rset.getString("GENRE"));
				bList.add(book);
			}
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bList;
	}
	
	public Book selectOneByBook(String bookName) {
		Book book = null;
		String sql = "SELECT * FROM BOOK_TBL WHERE BOOK_NAME = '"+bookName+"'";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			if(rset.next()) {
				book = new Book();
				book.setBookNumber(rset.getInt("BOOK_NUMBER"));
				book.setBookName(rset.getString("BOOK_NAME"));
				book.setWriterName(rset.getString("WRITER_NAME"));
				book.setPublisher(rset.getString("PUBLISHER"));
				book.setPrice(rset.getInt("PRICE"));
				book.setGenre(rset.getString("GENRE"));
			}
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public Book selectOneByWriter(String writerName) {
		Book book = null;
		String sql = "SELECT * FROM BOOK_TBL WHERE WRITER_NAME = '"+writerName+"'";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			if(rset.next()) {
				book = new Book();
				book.setBookNumber(rset.getInt("BOOK_NUMBER"));
				book.setBookName(rset.getString("BOOK_NAME"));
				book.setWriterName(rset.getString("WRITER_NAME"));
				book.setPublisher(rset.getString("PUBLISHER"));
				book.setPrice(rset.getInt("PRICE"));
				book.setGenre(rset.getString("GENRE"));
			}
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public int insertBook(Book book) {
		String sql = "INSERT INTO BOOK_TBL VALUES(?,?,?,?,?,?)";
		int result = 0;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book.getBookNumber());
			pstmt.setString(2, book.getBookName());
			pstmt.setString(3, book.getWriterName());
			pstmt.setString(4, book.getPublisher());
			pstmt.setInt(5, book.getPrice());
			pstmt.setString(6, book.getGenre());
			result = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteBook(String bookName) {
		String sql = "DELETE FROM BOOK_TBL WHERE BOOK_NAME = ?";
		int result = 0;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookName);
			result = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateBook(Book book) {
		int result = 0;
		String sql = "UPDATE BOOK_TBL SET WRITER_NAME ='"+book.getWriterName()+"', '"+book.getPublisher()+"', '"+book.getPrice()+"', '"+book.getGenre()+"' WHERE BOOK_NAME = '"+book.getBookName()+"'";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
