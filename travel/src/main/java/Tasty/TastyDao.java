package Tasty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import dbconn.DBConnect;

public class TastyDao {

	private DBConnect dbconn;
	
	public TastyDao() {
		dbconn = DBConnect.getInstance();
	}
	
	public void insert(TastyVo vo) {
		String sql = "insert into tasty values(tastyboard_seq.nextval,?,?,?,?,?,sysdate)";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setInt(2, vo.getCity_num());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContent());
			pstmt.setString(5, vo.getImg_path());
			pstmt.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
//			System.out.println("중복된 아이디. 다시 입력하시오");
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
	
	public TastyVo selectByTastyNum(int tasty_num) {
		TastyVo vo = null;
		ResultSet rs = null;
		
		String sql = "select * from tasty where tasty_num=?";
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tasty_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new TastyVo(rs.getInt(1), rs.getString(2), 
						rs.getInt(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getDate(7));
			}
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
		return vo;
	}

	public ArrayList<TastyVo> select(int city_num) {
		ResultSet rs = null;
		ArrayList<TastyVo> list = new ArrayList<>();
		
		String sql = "select * from tasty where city_num=?";
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, city_num);
						
			rs = pstmt.executeQuery();	
			while(rs.next()) {
				list.add(new TastyVo(rs.getInt(1), rs.getString(2), 
						rs.getInt(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getDate(7)));
			}
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
		return list;
	}

	// 수정
	public void update(TastyVo vo) {
		String sql = "update tasty set title=?, content=?, img_path=? where tasty_num=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getImg_path());
			pstmt.setInt(4, vo.getTasty_num());
			pstmt.executeUpdate();
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

	public void delete(int tasty_num) {
		String sql = "delete from tasty where tasty_num=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tasty_num);
			pstmt.executeUpdate();
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
	public ArrayList<TastyVo> selectAll() {
		ResultSet rs = null;
		ArrayList<TastyVo> list = new ArrayList<>();
		String sql = "select * from tasty";
		Connection conn = dbconn.conn();		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();	
			while(rs.next()) {
				list.add(new TastyVo(rs.getInt(1), rs.getString(2), 
						rs.getInt(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getDate(7)));
			}
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
		return list;
	}

	public ArrayList<TastyVo> selectByTitle(int city_num, String title) {
		ResultSet rs = null;
		ArrayList<TastyVo> list = new ArrayList<>();
		String sql = "select * from tasty where city_num=? and title like ?";
		Connection conn = dbconn.conn();		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, city_num);
			pstmt.setString(2, "%"+title+"%");
			rs = pstmt.executeQuery();	
			while(rs.next()) {
				list.add(new TastyVo(rs.getInt(1), rs.getString(2), 
						rs.getInt(3), rs.getString(4), rs.getString(5),rs.getString(6),rs.getDate(7)));
			}
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
		return list;
	}
}
