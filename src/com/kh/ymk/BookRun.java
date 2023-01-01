package com.kh.ymk;

import java.util.List;

public class BookRun {
	public static void main(String [] args) {
		BookView bView = new BookView();
		BookController bCon = new BookController();
		Book book = null;
		List<Book> bList = null;
		String bookName = "";
		String writerName = "";
		int bookNumber = 0;
		int result = 0;
		gohome :
		while(true) {
			int choice = bView.mainMenu();
			switch(choice) {
			case 0 : 
				// 프로그램 종료
				break gohome;
			case 1 : 
				// 전체 목록 조회
				bList = bCon.printAll();
				if(!bList.isEmpty()) {
					bView.showAll(bList);
				}else {
					bView.displayError("데이터가 존재하지 않습니다.");
				}
				break;
			case 2 : 
				// 도서명으로 조회
				bookName = bView.inputBookName("검색");
				bList = bCon.printAllByBook(bookName);
				if(!bList.isEmpty()) {
					bView.showAll(bList);
				}else {
					bView.displayError("일치하는 데이터가 없습니다.");
				}
				break;
			case 3 : 
				// 작가명으로 조회
				writerName = bView.inputWriterName("검색");
				book = bCon.printOneByWriter(writerName);
				if(book != null) {
					bView.showOne(book);
				}else {
					bView.displayError("일치하는 데이터가 없습니다.");
				}
				break;
			case 4 : 
				// 도서 등록
				book = bView.inputBook();
				result = bCon.registerBook(book);
				if(result > 0) {
					bView.displaySuccess("도서 등록 완료");
				}else {
					bView.displayError("등록 실패");
				}
				break;
			case 5 : 
				// 도서 정보 수정
				bookName = bView.inputBookName("수정");
				book = bCon.printOneByBook(bookName);
				if(book != null) {
					book = bView.modifyBook(book);
					bCon.modifyBook(book);
				}else {
					bView.displayError("일치하는 책이 없습니다.");
				}
				break;
			case 6 : 
				// 도서 목록 삭제
				bookName = bView.inputBookName("삭제");
				result = bCon.removeBook(bookName);
				if(result > 0) {
					bView.displaySuccess("삭제되었습니다.");
				}else {
					bView.displayError("삭제되지 않았습니다.");
				}
				break;
			default :
				bView.printMessage("잘못입력하셨습니다. 1 ~ 6 사이의 수를 입력해주세요.");
				break;
			}
		}
	}
}
