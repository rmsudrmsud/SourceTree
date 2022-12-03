package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//싱글톤
public class DBConnect {
	private static DBConnect dbconn = new DBConnect();
	private String url = "jdbc:oracle:thin:@localhost:1521/xe";
	//ctrl alt del -> 서비스 oracleservicexe 확인
	
	private DBConnect() {}
	
	public static DBConnect getInstance() {
		return dbconn;
	}
	
	public Connection conn() {
		try {
			//드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver"); 
			
			//세션수립
			return DriverManager.getConnection(url, "system", "chlrmsgud123");// 연결한 url,계정,비밀번호
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
