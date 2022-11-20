package dbconn;
import java.sql.*;

public class test {

	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";

		// String url = "jdbc:oracle:thin:@전자지갑이름_성능?TNS_ADMIN=/전자지갑파일경로/전자지갑파일";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "system";
		String pwd = "chlrmsgud123";

		Connection con = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("데이터베이스 연결 성공!!");

		} catch (Exception e) {

			System.out.println("데이터베이스 연결 실패!!");
			e.printStackTrace();

		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}