package review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;

public class ReviewDao {
	private DBConnect dbconn;

	public ReviewDao() {
		dbconn = DBConnect.getInstance();
	}
	
	public void insert(ReviewVo vo) {
		String sql= "insert into review values(review_seq.nextval,?,?,?,?,?,sysdate )";
		Connection conn=dbconn.conn();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getCity_num() );
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContent());
			pstmt.setString(5, vo.getImg_path());
			
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
	public ReviewVo selectByNum(int review_num) {
		String sql="select*from review where review_num=?";
		Connection conn=dbconn.conn();
		ReviewVo vo= null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				vo= new ReviewVo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7));
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
		}return vo;
	}
	public ArrayList<ReviewVo> selectAll(int city_num){
		String sql= "select*from review where city_num=? order by review_num";
		ArrayList<ReviewVo> list = new ArrayList<>();
		Connection conn=dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, city_num);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new ReviewVo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7))); 
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
			
		}return list;
	}
	
	public ArrayList<ReviewVo> selectByTitle(String title, int city_num) {
		String sql= "select * from review where title like ? and city_num=?";
		Connection conn=dbconn.conn();
		ArrayList<ReviewVo> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+title+"%");
			pstmt.setInt(2, city_num);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new ReviewVo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7))); 
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
		}return list;
		
	}
	
	public ArrayList<ReviewVo> selectById(String id) {
		String sql= "select * from review where id like ? ";
		Connection conn=dbconn.conn();
		ArrayList<ReviewVo> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+id+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new ReviewVo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getDate(7))); 
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
		}return list;
		
	}
	
	public void update(ReviewVo vo) {
		String sql="update review set title=?, content=? where Review_num=?";
		Connection conn=dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getReview_num());
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
	
	public void delete(int review_num) {
		String sql = "delete review where review_num=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, review_num);
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
}
