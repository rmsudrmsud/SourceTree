package review_rep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;
import review.ReviewVo;

public class ReviewRepDao {
	private DBConnect dbconn;

	public ReviewRepDao() {
		dbconn = DBConnect.getInstance();
	}
	
	public void insert(ReviewRepVo vo) {
		String sql="insert into review_rep values(review_rep_seq.nextVal,?,?,?,sysdate) ";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getReview_num());
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
	
	public ArrayList<ReviewRepVo> selectAll(int review_num){
		String sql="select*from review_rep where review_num=? order by review_rep_num ";
		ArrayList<ReviewRepVo> list = new ArrayList<>();
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new ReviewRepVo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getDate(5)));
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
	public ReviewRepVo selectByNum(int review_rep_num) {
		String sql="select * from review_rep where Review_rep_num=?";
		Connection conn=dbconn.conn();
		ReviewRepVo vo= null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_rep_num);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				vo= new ReviewRepVo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getDate(5));
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
	public void update(ReviewRepVo vo ) {
		String sql="update review_rep set content=? where Review_rep_num=?";
		Connection conn=dbconn.conn();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getContent());
			pstmt.setInt(2, vo.getReview_rep_num());
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
	
	public void delete(int review_rep_num) {
		String sql = "delete from review_rep where review_rep_num=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, review_rep_num);
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
	public ReviewRepVo selectByRNum(int review_num) {
		String sql="select * from review_rep where Review_num=?";
		Connection conn=dbconn.conn();
		ReviewRepVo vo= null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				vo= new ReviewRepVo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getDate(5));
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
}
