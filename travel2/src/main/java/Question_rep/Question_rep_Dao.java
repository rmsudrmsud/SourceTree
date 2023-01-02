package Question_rep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import Question.QuestionVo;
import dbconn.DBConnect;

public class Question_rep_Dao {
	private DBConnect dbconn;
	
	public Question_rep_Dao() {
		dbconn = DBConnect.getInstance();
	}
	
	public void insert(Question_rep_Vo vo) {
		String sql = "insert into question_rep values(seq_question_rep.nextval,?,?,?,sysdate)";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getQuestion_num());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getContent());
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
	
	public ArrayList<Question_rep_Vo> selectAll() {
		ResultSet rs = null;
		ArrayList<Question_rep_Vo> list = new ArrayList<>();
		String sql = "select * from question_rep order by question_rep_num";
		Connection conn = dbconn.conn();		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();	
			while(rs.next()){
				list.add(new Question_rep_Vo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getDate(5)));
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

	public ArrayList<Question_rep_Vo> selectByQuestionNum(int question_num) {
		
		ResultSet rs = null;
		ArrayList<Question_rep_Vo> list = new ArrayList<Question_rep_Vo>();
		
		String sql = "select * from question_rep where question_num=? order by question_rep_num";
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, question_num);
			rs = pstmt.executeQuery();
			while(rs.next()){
				list.add(new Question_rep_Vo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getDate(5)));
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
	public void update(Question_rep_Vo vo) {
		String sql = "update question_rep set content=? where question_rep_num=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getContent());
			pstmt.setInt(2, vo.getQuestion_rep_num());
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
	
	public Question_rep_Vo select(int question_rep_num) {
		ResultSet rs = null;//ResultSEt이 필요한 이유
		Question_rep_Vo vo = null;
		String sql = "select * from question_rep where question_rep_num=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, question_rep_num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				vo = new Question_rep_Vo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getDate(5));
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
	

	public void delete(int question_rep_num) {
		String sql = "delete from question_rep where question_rep_num=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, question_rep_num);
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
