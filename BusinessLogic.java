package SecondCode;

import java.sql.SQLException;
import java.util.ArrayList;

public class BusinessLogic {
	
	public void LoanAvailable() {
		
		LibraryDAO dao = new LibraryDAO();
		
	}
	
	public void BookInfo() throws SQLException {
		
		LibraryDAO dao = new LibraryDAO();
		
		ArrayList<BookVO> list = dao.selectBook();
		
		System.out.println("도서명 | 저자 | 가격 | 대여 가능 여부");
		
		for(BookVO vo : list) {
			
			System.out.println(vo.getBook_name()+"|"+ vo.getWriter()+"|"+vo.getPrice() +"|" + vo.getLoan_yn());
			
		}
	}
	
	public void insertLoan(int std_no,int book_no) throws SQLException {
		
		LibraryDAO dao = new LibraryDAO();
		
		dao.insertLoan(std_no, book_no);
	}
	
	public void returnLoan(int std_no,int book_no) throws SQLException {
		
		LibraryDAO dao = new LibraryDAO();
		
		dao.returnLoan(std_no, book_no);
		
	}
}
