package SecondCode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LibraryDAO {
	
	public ArrayList<BookVO> selectBook() throws SQLException {
		
		ArrayList<BookVO> list = null;
		
		String sql = "select * from booktbl;";
		
		Connection con = ConnectionManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		list = new ArrayList<BookVO>();
		
		while(rs.next()) {
			BookVO vo  = new BookVO(rs.getInt(1),rs.getString(2),rs.getString(3),
					rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getString(7));
			list.add(vo);
		}
		
		rs.close();
		
		pstmt.close();
		
		con.close();
		
		return list;
	}
	
	public void insertLoan(int std_no,int book_no) throws SQLException {
		
		Date now = new Date();
		
		DateTimeService dts = new DateTimeService();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String sql = "insert into loantbl(loan_date,exp_return_date,std_no,book_no,return_date,return_yn,update_time)"
				+ " values(?,?,?,?,?,?,?);";//대여 테이블 값 입력
		
		String sql2 = "update booktbl set loan_yn = 'N' , update_time = ? where book_no = ?";
		//도서 테이블 예약 가능 N 업데이트
		
		String sql3 = "update studenttbl set loan_cnt = loan_cnt + 1 , update_time = ? where std_no = ?"; 
		// 학생 테이블 대여 권수 + 1 업데이트
		
		Connection con = ConnectionManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,dts.getNow());
		pstmt.setString(2,dts.calDate(dts.getNow(), 7));
		pstmt.setInt(3, std_no);
		pstmt.setInt(4, book_no);
		pstmt.setString(5, "");
		pstmt.setString(6, "N");
		pstmt.setString(7, null);
		
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		pstmt2.setString(1,simpleDateFormat.format(now));
		pstmt2.setInt(2, book_no);
		
		PreparedStatement pstmt3 = con.prepareStatement(sql3);
		pstmt3.setString(1,simpleDateFormat.format(now));
		pstmt3.setInt(2, std_no);
		
		int updateQuery =  pstmt.executeUpdate();
		
		int updateQuery2 = pstmt2.executeUpdate();
		
		int updateQuery3 = pstmt3.executeUpdate();
		
		if(updateQuery > 0 && updateQuery2 > 0 && updateQuery3 > 0) {
			System.out.println("대여 완료");
		}
		
		pstmt.close();
		
		con.close();
		
	}
	
	public void returnLoan(int std_no,int book_no) throws SQLException {
		
		Date now = new Date();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		DateTimeService dts = new DateTimeService();
		
		String sql = "update loantbl set return_date = ? , return_yn = ? , update_time = ?";
		//대여 테이블 반납 날짜, 반납 여부 업데이트
		
		String sql2 = "update booktbl set loan_yn = 'Y' , update_time = ? where book_no = ?";
		//도서 테이블 대여가능 여부 업데이트
		
		String sql3 = "update studenttbl set loan_cnt = loan_cnt - 1 , update_time = ? where std_no = ?";
		//학생 테이블 대여 권수 -1 업데이트
		
		Connection con = ConnectionManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1,dts.getNow());
		pstmt.setString(2,"Y");
		pstmt.setString(3, simpleDateFormat.format(now));
		
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		
		pstmt2.setString(1,simpleDateFormat.format(now));
		pstmt2.setInt(2,book_no);
		
		PreparedStatement pstmt3 = con.prepareStatement(sql3);
		
		pstmt3.setString(1,simpleDateFormat.format(now));
		pstmt3.setInt(2,std_no);
		
		int updateQuery =  pstmt.executeUpdate();
		
		int updateQuery2 =  pstmt2.executeUpdate();
		
		int updateQuery3 =  pstmt3.executeUpdate();
		
		if(updateQuery > 0 && updateQuery2 > 0 && updateQuery3 > 0) {
			System.out.println("반납 완료");
		}
		
		pstmt.close();
		
		con.close();
		
	}
	
}
