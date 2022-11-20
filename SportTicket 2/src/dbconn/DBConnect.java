//이녀석은바뀔일이거의 없음. 그래서 따로 패키지 빼놔씀
package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//싱글톤으로 DBConnect
public class DBConnect {
	private static DBConnect dbconn = new DBConnect();
	private String url = "jdbc:oracle:thin:@localhost:1521/xe"; //@ : 연결할 db의주소
	private DBConnect() {}
	
	public static DBConnect getInstance() {
		return dbconn;
	}
	
	public Connection conn() { //db와의연동 유지
	
		try {//드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver"); // << 드라이버경로.
			
			//세션수립
			return DriverManager.getConnection(url, "system", "chlrmsgud123"); //(url, 계정, 비밀번호);
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
