package place;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;

public class PlaceDao {
	private DBConnect dbconn;
	
	public PlaceDao () {
		dbconn = DBConnect.getInstance();
	}
	
	//명소 추가
	public void insert(PlaceVo vo) {
		String sql = "insert into place values(place_seq.nextval,?,?,?,?,?,sysdate)";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getCity_num());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContent());
			pstmt.setString(5, vo.getImg_path());
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
	
	//명소 번호로 검색
	public PlaceVo select(int place_num) {
		ResultSet rs = null;
		PlaceVo vo = null;
		String sql = "select * from place where place_num=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, place_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new PlaceVo(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7));
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
	//명소 제목으로 검색
	public ArrayList<PlaceVo> selectByTitle(String title, int city_num) {
		ResultSet rs = null;
		ArrayList<PlaceVo> list = new ArrayList<PlaceVo>();
		String sql = "select * from place where title like ? and city_num=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+title+"%");
			pstmt.setInt(2, city_num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new PlaceVo(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7)));
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
	//명소 전체 출력
	public ArrayList<PlaceVo> selectAll(int city_num){
		ResultSet rs = null;
		ArrayList<PlaceVo> list = new ArrayList<PlaceVo>();
		String sql = "select * from Place where city_num=? order by place_num";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, city_num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new PlaceVo(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7)));
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
	
	//명소 수정
	public void update(PlaceVo vo) {
		String sql = "update place set title=?, content=?, img_path=? where place_num=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getImg_path());
			pstmt.setInt(4, vo.getPlace_num());
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
	
	//명소 삭제
	public void delete(int place_num) {
		String sql = "delete from place where place_num=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, place_num);
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
}