package employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;

public class EmpDao {
	private DBConnect dbconn; //db와 연동하는 객체. arraylist대신 사용할 db.
	
	public EmpDao() {
		dbconn = DBConnect.getInstance(); //싱글톤 얻어오는 getInstance
	}
	
	//전체검색
	public ArrayList<EmpVo> selectAll(){
		//실행할 sql문 작성
		String sql = "select employee_id, last_name, department_id, job_id, hire_date, salary from Sample";
		
		//db연결
		Connection conn = dbconn.conn();
		ArrayList<EmpVo> list = new ArrayList<>();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql); //PreparedStatement 객체생성. con~에서 얻어옴.파라메터로(sql);
			//Resultset : 검색결과 테이블
			ResultSet rs = pstmt.executeQuery(); //sql 실행(?). executeQuery : 오라클의 select
			
			
			//rs.next(): 테이블에서 다음줄로 이동하는 메서드. 맨처음에 실행하면 첫번째줄
			while(rs.next()) {
				String eid = rs.getString(1); //get : 컬럼의값을 읽어들이는 메서드. ( 1 ) -> 1번컬럼. 컬럼의순서 //쿼리문에서의순서
				String name = rs.getString(2);
				String did = rs.getString(3); //department id(?)
				String job = rs.getString(4); //직무
				String hire = rs.getString(5);
				String sal = rs.getString(6);
				
				EmpVo vo = new EmpVo(eid, name, did, job, hire, sal); //vo에 담기
				list.add(vo); //어레이리스트에 vo 추가
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { //while 다돌고나서 db와의 연동끊는부분!
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public EmpVo select(int eid) { //파라메터 변수 eid
		//1.sql 작성
		//"select employee_id, last_name, department_id, job_id, hire_date, salary from Sample" 에서 where 조건 .employee_id와 같은녀석
		String sql = "select employee_id, last_name, department_id, job_id, hire_date, salary from Sample where employee_id='"+eid+"'";
		
		//2.db연결
		Connection conn = dbconn.conn();
		
		//3. sql을 실행할 preparedstatement 객체 생성
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql); //(행하고싶은 sql)
			pstmt.setInt(1,  eid);
			
			//4. excuteQuery()로 sql 실행.
			ResultSet rs = pstmt.executeQuery();
			
			//5. ResultSet에서 값을 하나씩 꺼내어서 vo에 담기
			if(rs.next()) { //검색된 한줄이 있다면 처리
				String id = rs.getString(1); 
				String name = rs.getString(2);
				String did = rs.getString(3); 
				String job = rs.getString(4); 
				String hire = rs.getString(5);
				String sal = rs.getString(6);
				return new EmpVo(id, name, did, job, hire, sal);
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
	
}
