package reservation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;
import member.MemberService;
import sports.SportsDao;
import sports.SportsVo;

public class ReservationDao {
	private DBConnect dbconn;
	ReservationVo vo = new ReservationVo();
	ReservationDao dao;
	SportsDao dao2;

	public ReservationDao() {
		dbconn = DBConnect.getInstance();
	}

	// 예매하기

	public void insert(ReservationVo vo) {
		String sql = "insert into reservation values(res_seq.nextVal,?,?,?,?,?,sysdate)";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMemId());
			pstmt.setInt(2, vo.getSport_seq());
			pstmt.setString(3, vo.getRes_num());
			pstmt.setInt(4, vo.getPayment());
			pstmt.setInt(5, vo.getPrice());

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

	// 축구 종목 출력
	public ArrayList<SportsVo> printSoccer() {
		String sql = "select * from sports where name like '%축구%'";
		Connection conn = dbconn.conn();
		ArrayList<SportsVo> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int sport_seq = rs.getInt(1);
				String name = rs.getString(2);
				String spo_date = rs.getString(3);
				String location = rs.getString(4);
				String team = rs.getString(5);
				String txt = rs.getString(6);

				SportsVo vo = new SportsVo(sport_seq, name, spo_date, location, team, txt);
				list.add(vo);

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

	// 농구 종목 출력
	public ArrayList<SportsVo> printBasketball() {
		String sql = "select * from sports where name like '%야구%'";
		Connection conn = dbconn.conn();
		ArrayList<SportsVo> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int sport_seq = rs.getInt(1);
				String name = rs.getString(2);
				String spo_date = rs.getString(3);
				String location = rs.getString(4);
				String team = rs.getString(5);
				String txt = rs.getString(6);

				SportsVo vo = new SportsVo(sport_seq, name, spo_date, location, team, txt);
				list.add(vo);

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

	// id로 예약내역출력
	public ArrayList<ReservationVo> printMyRes(String memId) {
		String sql = "select * from reservation where memId=?";
		Connection conn = dbconn.conn();
		ArrayList<ReservationVo> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new ReservationVo(rs.getInt(1), MemberService.loginId, rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getDate(7));
				list.add(vo);
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

	// id로 예약삭제
	public void deleteMyRes(String id, int sport_seq) {
		String sql = "delete from reservation where memId=? and sport_seq=?";
		Connection conn = dbconn.conn();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, sport_seq);
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

	// 좌석번호 중목 제외
	public ArrayList<ReservationVo> selectAll(String res_num, int sport_seq) {
		String sql = "select*from reservation where res_num=? and sport_seq=?";
		Connection conn = dbconn.conn();
		ArrayList<ReservationVo> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, res_num);
			pstmt.setInt(2, sport_seq);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new ReservationVo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getDate(7));
				list.add(vo);
			}
			
			return list;

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
		return null;
	}

}