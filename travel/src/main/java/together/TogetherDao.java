package together;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;


public class TogetherDao {
	private DBConnect dbconn;
	
	public TogetherDao () {
		dbconn = DBConnect.getInstance();
		
	}
	
	public void insert (TogetherVo vo ) {
		String sql = "insert into Travel values(travel_seq.nextval,?,?,?,?,?,sysdate)";
		
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getCity_num());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContent());
			pstmt.setInt(5, vo.getPpl());
			
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
	
	 public TogetherVo select(int travel_rep_num) {
		   TogetherVo vo = null;
			ResultSet rs = null;
			
			String sql = "select * from travel where travel_num=?";
			Connection conn = dbconn.conn();
			
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,travel_rep_num);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					vo = new TogetherVo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getDate(7));
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
	 
	 
	public ArrayList<TogetherVo> selectByTitle (String title, int city_num) {
		
		ResultSet rs = null;
		ArrayList<TogetherVo> list = new ArrayList<TogetherVo>();
		
		String sql = "select * from travel where title like ? and city_num=?";
		
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+title+"%");
			pstmt.setInt(2, city_num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new TogetherVo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getDate(7)));
				
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
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return list;
	}
	
public ArrayList<TogetherVo> selectBycNum (int city_num) {
		
		ResultSet rs = null;
		ArrayList<TogetherVo> list = new ArrayList<>();
		
		String sql = "select * from travel where city_num=?";
		
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, city_num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new TogetherVo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getDate(7)));
				
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
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return list;
	}
	public void update (TogetherVo vo) {
		String sql = "update travel set title=?, content=? ,ppl=? where travel_num=?";
		
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle() );
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getPpl());
			pstmt.setInt(4,vo.getTravel_num());
			
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
	public void delete (int travel_num) {
		String sql = "delete travel where travel_num =?" ;
		
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, travel_num);
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
		public ArrayList<TogetherVo> selectAll () {
			
			ResultSet rs = null;
			ArrayList<TogetherVo> list = new ArrayList<>();
			
			String sql = "select * from travel";
			
			Connection conn = dbconn.conn();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				while (rs.next()) {
					list.add(new TogetherVo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getDate(7)));
					
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
				}finally {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			return list;
		}
	
    }

