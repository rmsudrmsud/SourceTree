//게시판 board만들기
//글작성 insert 
//글번호로검색 select 
//글작성자로검색 selectByWriter
//글제목으로검색 selectByTitle like로 
//글목록 selectAll()
//수정(제목,내용)update - 글번호로 검색. ->자기글에대헤서만 수정, 삭제
//삭제delete -글번호로 ->자기글에대헤서만 수정, 삭제
package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;


public class BoardDao {
	private DBConnect dbconn;
	public BoardDao() {
		dbconn = DBConnect.getInstance();
	}
	//글작성
	public void insert(BoardVo vo) {
		//글번호 nextval자동할당, 날짜 sysdate
		String sql = "insert into Board values(seq_board.nextval,?,sysdate,?,?)";	
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt+"글이 추가");
					
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
	//글번호로검색 select
	public BoardVo select(int num) {
		String sql = "select*from Board where num=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return new BoardVo(rs.getInt(1),rs.getString(2),rs.getDate(3), rs.getString(4), rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//글 작성자로 검색
	public BoardVo selectByWriter(String writer) {
		String sql = "select*from Board where writer=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return new BoardVo(rs.getInt(1),rs.getString(2),rs.getDate(3), rs.getString(4), rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//글제목으로검색 selectByTitle like로 포함해서.
	public ArrayList<BoardVo> selectByTitle(String title){
		String sql = "select*from Board where title like ?";
		
		ArrayList<BoardVo> list = new ArrayList<>();
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//셀렉트실행시 ResultSet 반환
			pstmt.setString(1, title); 
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BoardVo(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5)));			
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
	
	//전체출력
	public ArrayList<BoardVo> selectAll(){
		ArrayList<BoardVo> list = new ArrayList();
		String sql = "select * from board order by num desc"; //최신걸보기위한 내림차순
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new BoardVo(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	//수정(글번호로 찾아서 제목,내용) 자기것만.
	public void update (BoardVo vo) {
		String sql = "update board set title=?, content=? where num=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getNum());
			
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
	
	//삭제 삭제delete -글번호로
	public void delete(int num) {
		String sql = "delete from Board where num=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
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
	
	//페이징. start는 rownum 시작값, end는 rownum 끝값
	public ArrayList<BoardVo> selectAllPaging(int start, int end) {
		String sql ="select *from (select rownum r, num, writer," + "title from board order by num desc)" + "where r between ? and ?";
		Connection conn = dbconn.conn();
		ArrayList<BoardVo> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BoardVo(rs.getInt(2), rs.getString(3), null, rs.getString(4), null)); //첫번쨰 컬럼은 rownum이니까 사용x
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
	//전체행수 
	public int getCnt() {
		String sql = "select count(*) from board";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
}
