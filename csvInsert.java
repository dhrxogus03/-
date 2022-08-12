package SecondCode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class csvInsert {
	
	public static void StudentInsert(ArrayList<StudentVO> list) throws SQLException {
		
		String sql = "insert into studentTBL(std_no,std_name,major,age,rsvs_cnt,loan_cnt,stop_date) "
				+ "values(?,?,?,?,?,?,?)";
		
		Connection con = ConnectionManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		for(StudentVO vo : list) {
			
			pstmt.setInt(1,vo.getStd_no());
			pstmt.setString(2, vo.getStd_name());
			pstmt.setString(3, vo.getMajor());
			pstmt.setInt(4, vo.getAge());
			pstmt.setInt(5, vo.getRsvs_cnt());
			pstmt.setInt(6, vo.getLoan_cnt());
			pstmt.setString(7,vo.getStop_date());
			
			boolean flag = pstmt.execute();
			
			if(!flag) {
				System.out.println("입력완료");
			} else {
				System.out.println("입력실패");
			}
		}
	}
	
	public static void BookInsert(ArrayList<BookVO> list) throws SQLException {
		
		String sql = "insert into bookTBL(book_no,book_name,writer,price,pay_date,rsvs_people,loan_yn) "
				+ "values(?,?,?,?,?,?,?)";
		
		Connection con = ConnectionManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		for(BookVO vo : list) {
			
			pstmt.setInt(1,vo.getBook_no());
			pstmt.setString(2, vo.getBook_name());
			pstmt.setString(3, vo.getWriter());
			pstmt.setInt(4, vo.getPrice());
			pstmt.setString(5, vo.getPay_date());
			pstmt.setInt(6, vo.getRsvs_people());
			pstmt.setString(7,vo.getLoan_yn());
			
			boolean flag = pstmt.execute();
			
			if(!flag) {
				System.out.println("입력완료");
			} else {
				System.out.println("입력실패");
			}
		}
		
	}
}
