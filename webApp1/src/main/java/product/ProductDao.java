package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;

public class ProductDao {
	
	private DBConnect dbconn;
	
	public ProductDao () {
		dbconn = DBConnect.getInstance();
	}
	//제품등록
	public void insert(ProductVo vo){
		String sql = "insert into Product values(seq_product.nextval,?,?,?)";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3, vo.getAmount());
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
	//번호로검색
	public ProductVo selectNum(int num){
		ProductVo vo = null;
		ResultSet rs = null;

		String sql = "select * from Product where num=?";
		Connection conn = dbconn.conn();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new ProductVo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)); //vo에담아서
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
		return vo; //vo리턴
	}
	//이름으로 검색
	public ArrayList<ProductVo> selectByName(String name){ // like 패턴
		ArrayList<ProductVo> list = new ArrayList<>();
		ResultSet rs = null;
		String sql = "select * from Product where name like ? order by num";
		
		
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%"+name+"%"); //%name% name이 포함된녀석들 모두찾기
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new ProductVo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}return list;
		
	}
	
	//낮은가격에서 높은가격 가격으로 검색. where between and
	public ArrayList<ProductVo> selectByPrice(int low, int high){
		ArrayList<ProductVo> list = new ArrayList<>();
		ResultSet rs = null;
		
		String sql = "select * from product where price between ? and ? order by num";
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, low);
			pstmt.setInt(2, high);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new ProductVo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return list;
	}
	
	//전체출력
	public ArrayList<ProductVo> selectAll(){
		ResultSet rs = null;
		ArrayList<ProductVo> list = new ArrayList<>();
		String sql = "select*from product";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new ProductVo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
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
		}return list;
	}
	
	//상품명,가격,수량  수정. - 번호로 찾아서
	public void update(ProductVo vo){
	String sql = "update product set name=?, price=?, amount=? where num=?"; // ','<<<빼먹지말기!!!!!!!!!!
	Connection conn = dbconn.conn();
	try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setInt(2, vo.getPrice());
		pstmt.setInt(3, vo.getAmount());
		pstmt.setInt(4, vo.getNum());
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
	//삭제
	public void delete(int num){
		String sql = "delete Product where num=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
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
