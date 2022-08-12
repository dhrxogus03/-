package SecondCode;

import java.sql.SQLException;

public class MainUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MainUI main = new MainUI();
		
		try {
			main.insertLoan();
			main.BookInfo();
			main.returnLoan();
			main.BookInfo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertLoan() throws SQLException {

		BusinessLogic bl = new BusinessLogic();
		
		bl.insertLoan(20170123,7302);
		
	}
	
	public void returnLoan() throws SQLException {

		BusinessLogic bl = new BusinessLogic();
		
		bl.returnLoan(20170123,7302);
		
	}
	
	public void BookInfo() throws SQLException {
		
		BusinessLogic bl = new BusinessLogic();
		
		bl.BookInfo();
	}

}
