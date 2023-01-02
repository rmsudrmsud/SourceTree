package Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import dbconn.DBConnect;

public class QuestionDao {

	private DBConnect dbconn;
	
	public QuestionDao() {
		dbconn = DBConnect.getInstance();
	}
	
	public void insert(QuestionVo vo) {
		String sql = "insert into question values(seq_question.nextval,?,?,?,?,sysdate)";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getImg_path());
			pstmt.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("중복된 아이디. 다시 입력하시오");
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

	public ArrayList<QuestionVo> selectByTitle(String title) {
		
		ResultSet rs = null;
		ArrayList<QuestionVo> list = new ArrayList<QuestionVo>();
		
		String sql = "select * from question where title like ?";
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+title+"%");
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new QuestionVo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6)));
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
	public void update(QuestionVo vo) {
		String sql = "update question set title=?, content=?, img_path=? where question_num=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getImg_path());
			pstmt.setInt(4, vo.getQuestion_num());
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

	public void delete(int question_num) {
		String sql = "delete from question where question_num=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, question_num);
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
	public ArrayList<QuestionVo> selectAll() {
		ResultSet rs = null;
		ArrayList<QuestionVo> list = new ArrayList<>();
		String sql = "select * from question";
		Connection conn = dbconn.conn();		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();	
			while(rs.next()) {
				list.add(new QuestionVo(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), rs.getString(5),rs.getDate(6)));
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
	
	public QuestionVo select(int question_num) {
		ResultSet rs = null;//ResultSEt이 필요한 이유
		QuestionVo vo = null;
		String sql = "select * from question where question_num=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, question_num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				vo = new QuestionVo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6));
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

}
