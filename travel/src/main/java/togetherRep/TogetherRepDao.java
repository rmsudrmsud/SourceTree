package togetherRep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;

public class TogetherRepDao {
	private DBConnect dbconn;

	public TogetherRepDao() {
		dbconn = DBConnect.getInstance();

	}

	public void insert (TogetherRepVo vo) {
		String sql = "insert into Travel_rep values (travel_rep_seq.nextval, ?,?,?,sysdate)";
		Connection conn = dbconn.conn();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getTravel_num());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public TogetherRepVo select (int travel_rep_num){
		ResultSet rs = null;
		TogetherRepVo vo = null;
		 
		 String sql = "select * from Travel_rep where travel_rep_num=? ";
		 
		 Connection conn = dbconn.conn();
		 
		 try {
			PreparedStatement pstmt= conn.prepareStatement(sql);
		    pstmt.setInt(1, travel_rep_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
					vo=new TogetherRepVo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getDate(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { 
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 return vo;
	}
	
	
	public void update (TogetherRepVo vo) {
		String sql = "update travel_rep set content=? where travel_rep_num =?";

		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getContent());
			pstmt.setInt(2, vo.getTravel_rep_num());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void delete (int travel_rep_num) {
		String sql = "delete from travel_rep where travel_rep_num=?";
		Connection conn = dbconn.conn();


		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, travel_rep_num);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
	public ArrayList<TogetherRepVo> selectByNum (int travel_num){
		ResultSet rs = null;
		 ArrayList<TogetherRepVo> list = new ArrayList<>();
		 
		 String sql = "select * from Travel_rep where travel_num=? order by travel_rep_num";
		 
		 Connection conn = dbconn.conn();
		 
		 try {
			PreparedStatement pstmt= conn.prepareStatement(sql);
		    pstmt.setInt(1, travel_num);
			rs=pstmt.executeQuery();
			while (rs.next()) {
					list.add(new TogetherRepVo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getDate(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { 
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 return list;
	}
	
	public ArrayList<TogetherRepVo> selectAll (){
		ResultSet rs = null;
		 ArrayList<TogetherRepVo> list = new ArrayList<>();
		 
		 String sql = "select * from Travel_rep";
		 
		 Connection conn = dbconn.conn();
		 
		 try {
			PreparedStatement pstmt= conn.prepareStatement(sql);
		   
			pstmt.executeQuery();
			while (rs.next()) {
					list.add(new TogetherRepVo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getDate(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { 
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

