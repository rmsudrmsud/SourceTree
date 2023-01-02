package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//싱글톤
public class DBConnect {
	private static DBConnect dbconn = new DBConnect();
	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	
	private DBConnect() {}
	
	public static DBConnect	getInstance() {
		return dbconn;
	}
	
	public Connection conn() {//로그인세션 . 유지
		try {
			//드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");
			
			//세션수립
			return DriverManager.getConnection(url, "hr", "hr");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
