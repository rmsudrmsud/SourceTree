package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import dbconn.DBConnect;

public class MemberDao {
	
	private DBConnect dbconn;
	
	public MemberDao() {
		dbconn = DBConnect.getInstance();
	}
	

	//id에 해당하는 회원 정보 select
	public MemberVo selectMember(String id) {
		String sql = "select * from member where memId =?";
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			MemberVo list = null;
			if(rs.next()) {
				list = new MemberVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
			}
			return list;
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}//selectMember
	
	
	//관리자 로그인 확인
	public String selectMaster() {
		String sql = "select memId from member where master=1";
		Connection conn = dbconn.conn();
		String master = " ";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				master = rs.getString(1);
			}
			return master;
			
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
		return null;
	}//selectMaster
	
	
	
	//id에 해당하는 회원 정보 update
	public void updateMember(MemberVo vo, String id) {
		String sql = "update member set name=?, pwd=?, email=?, addr=? where memId =?";
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getPwd());
			ps.setString(3, vo.getEmail());
			ps.setString(4, vo.getAddr());
			ps.setString(5, id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//updateMember()
	
	//id에 해당하는 회원 정보 delete
	public void deleteMember(String id) {
		String sql = "delete from member where memId =?";
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//deleteMember
	
	//회원 정보 insert
	public void insertMember(MemberVo vo) {
		String sql = "insert into member values(?,?,?,?,0,?,0)";
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getMemId());
			ps.setString(2, vo.getPwd());
			ps.setString(3, vo.getEmail());
			ps.setString(4, vo.getAddr());
			ps.setString(5, vo.getName());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//insertMember
	
}//MemberDAO