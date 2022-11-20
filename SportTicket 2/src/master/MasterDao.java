package master;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;
import member.MemberVo;
import post.PostVo;
import reservation.ReservationVo;
import sports.SportsVo;

public class MasterDao {
	private DBConnect dbconn;
	public MasterDao() {
		dbconn = DBConnect.getInstance();
	}
	
	//전체회원정보확인
	public ArrayList<MemberVo> selectAll(){
		ArrayList<MemberVo> list = new ArrayList();
		String sql = "select * from member";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new MemberVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7)));
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
	
	//회원정보 id로 검색
	public MemberVo selectMemid(String memId) {
		String sql = "select*from member where memId=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return new MemberVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
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
		return null;
	}
	//회원정보 삭제delete - id로 
		public void deleteMemid(String memId) {
			String sql = "delete from member where memId=?";
			Connection conn = dbconn.conn();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memId);
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
		
	//회원블랙리스트 확인
		public void printBlacklist() {
			String sql = "select memId, name from Member where blacklist=1";
			Connection conn = dbconn.conn();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					System.out.println("id: "+rs.getString(1)+", 이름: "+rs.getString(2));
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
		}
	//블랙리스트 회원 추가
		public void insertBlack(String memId) {
			String sql = "update member set blacklist=1 where memid=?";
			Connection conn = dbconn.conn();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql); 
				pstmt.setString(1, memId);
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
	//id로 블랙리스트 삭제
		public void deleteBlack(String memId) {
//			String sql = "delete from member where blacklist=1 and memid=?"; 
			String sql = "update member set blacklist=0 where blacklist=1 and memid=?"; //진짜 삭제가아니고 blacklist값을 변경!!
			Connection conn = dbconn.conn();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memId);
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
	//경기추가
		public void insertSports(SportsVo vo) {
			//글번호 nextval자동할당, 날짜 sysdate
			String sql = "insert into Sports values(sport_seq.nextval,?,?,?,?,?)";	
			Connection conn = dbconn.conn();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql); 
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getSpo_date());
				pstmt.setString(3, vo.getLocation());
				pstmt.setString(4, vo.getTeam());
				pstmt.setString(5, vo.getText());
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
	//경기번호 호출
		public ArrayList<Integer> selectSpo_seq() {
			ArrayList<Integer> list = new ArrayList();
			String sql = "select sport_seq from sports";
			Connection conn = dbconn.conn();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					list.add(rs.getInt(1));
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
			} return list;
		}
	//게시판 번호 호출
//		public ArrayList<Integer> selectPost_seq() {
//			ArrayList<Integer> list = new ArrayList();
//			String sql = "select post_seq from post";
//			Connection conn = dbconn.conn();
//			try {
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				ResultSet rs = pstmt.executeQuery();
//				while(rs.next()) {
//					list.add(rs.getInt(1));
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} finally {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			} return list;
//			
//		}
	//경기번호로 경기수정
		public void update (SportsVo vo) {
			String sql = "update Sports set name=?, spo_date=?, location=?, team=?, text=? where sport_seq=?";
			Connection conn = dbconn.conn();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getSpo_date());
				pstmt.setString(3, vo.getLocation());
				pstmt.setString(4, vo.getTeam());
				pstmt.setString(5, vo.getText());
				pstmt.setInt(6, vo.getSport_seq());
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
		
	// 글번호로 경기종목삭제
		public void deleteSports(int sport_seq) {
			String sql = "delete from Sports where sport_seq=?";
			Connection conn = dbconn.conn();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, sport_seq);
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
	//id로 게시글검색
		public PostVo selectById(String memId) {
			String sql = "select*from post where memId=?";
			Connection conn = dbconn.conn();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memId);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					return new PostVo(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getDate(5), rs.getDate(6), rs.getInt(7));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return null;
		}
		
	//글번호로 게시글삭제
		public void deletePost(int post_seq) {
			String sql = "delete from post where post_seq=?";
			Connection conn = dbconn.conn();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, post_seq);
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
	//경기별 결제/미결제회원 확인 => 미결제회원출력
		public ArrayList<ReservationVo> payment() {
			ArrayList<ReservationVo> list = new ArrayList<>();
			String sql = "select*from Reservation where payment=0";
			Connection conn = dbconn.conn();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					list.add(new ReservationVo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getDate(7)));
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
	//미결제회원 메시지보내기 . 서비스-> 보내시겠습니까? y/no보냈습니다
//		public String send() {
//			String sql = "select memid from reseveration where payment=1";
//			Connection conn = dbconn.conn();
//			String id = " ";
//			try {
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				ResultSet rs=pstmt.executeQuery();
//				if(rs.next()) {
//					
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}finally {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			return 
//		}
}
