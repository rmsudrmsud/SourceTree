package sports;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;

public class SportsDao {
	private DBConnect dbconn;
	
	SportsDao dao;
	SportsVo vo = new SportsVo();
	public SportsDao() {
		dbconn = DBConnect.getInstance();
	}
	
	
	//매치정보 출력
	
	public ArrayList<SportsVo> selectAll() {
		
		String sql = "select * from sports";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			ArrayList<SportsVo> list = new ArrayList<>();
			while(rs.next()) {
								
				int sport_seq  = rs.getInt(1);
				String name=rs.getString(2);
				String spo_date=rs.getString(3);
				String location=rs.getString(4);
				String team= rs.getString(5);
				String txt=rs.getString(6);
						
				SportsVo vo= new SportsVo(sport_seq, name, spo_date, location, team, txt);
				list.add(vo);
				
			}
			return list;
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
	}//selectAll

}