package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import dbconn.DBConnect;

public class MemberDao {
	private DBConnect dbconn;
	
	public MemberDao() {
		dbconn = DBConnect.getInstance();
	}
	//회원가입
	public void insert(MemberVo vo) {
		String sql = "insert into member1 values(?,?,?,?)";
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail()); //sql문완성
			
			pstmt.executeUpdate(); //실행
		}catch(SQLIntegrityConstraintViolationException e){
			System.out.println("중복된 아이디 다시입력하시오");
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close(); //db연결종료
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	//내정보확인
	public MemberVo select(String id) {
		MemberVo vo = null;
		ResultSet rs = null;
		
		String sql = "select*from member1 where id=?";
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {//rx.next 첫번째줄 이동.
			vo = new MemberVo(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}
	
	//pwd수정 void update(MemberVO vo){}
	public void update(MemberVo vo) {
		String sql = "update member1 set pwd=? where id=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getId());
			
			pstmt.executeUpdate(); //실행
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	//탈퇴 void delete(String id) {}
	public void delete(String id) {
		String sql = "delete from member1 where id=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate(); //실행
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
}
