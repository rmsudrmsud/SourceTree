package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconn.DBConnect;

public class test1Dao {
	private DBConnect dbconn; //db연결 객체
	
	public test1Dao() {
		dbconn = DBConnect.getInstance();
	}
	
	//insert 만들기. 쓰기작업은 반환값 필요x -> void
	public void insert(test1Vo vo) { //insert : 어레이리스트에 추가할 vo객체 받아오기. 파라페터 vo
		//1. sql작성
		//vo입력받을값 모르니까?. 날짜는 오늘날짜 할거니까 sysdate
		String sql = "insert into test1 values(?,?,?,sysdate)";
		
		//2. db연결
		Connection conn = dbconn.conn();
		try {
		//3. preparedStatement 객체 생성
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//4. ?매칭
		pstmt.setInt(1, vo.getNum()); //1번물음표 매칭
		pstmt.setString(2, vo.getName());//2번물음표 매칭
		pstmt.setString(3, vo.getTel());//3번물음표 매칭
		
		//5. sql 실행 . insert, update, delete executeUpdate()로 실행
		//select : executequery()로 실행
		int cnt = pstmt.executeUpdate(); //쓰기가 적용된 행수를 반환
		System.out.println(cnt + "줄 추가됨");
		} catch(SQLException e) {
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
	
	//num으로 검색
	public test1Vo select(int num) {
		//1. sql 작성
		String sql = "select*from test1 where num=?";
		//2. db 연결
		Connection conn = dbconn.conn();
		//3.연결할 pstmt객체생성
		try {
			PreparedStatement pstmt= conn.prepareStatement(sql);
			//?매칭. set(물음표순서, 파라메터값)
			pstmt.setInt(1, num);
			//sql실행. executeQuery() select. 
			//ResultSet : 검색결과 테이블
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {//rx.next 첫번째줄 이동.
//				int n = rs.getInt(1); //true 일때 컬럼값 꺼내기
//				String name = rs.getString(2);
//				String tel = rs.getString(3);
//				Date d = rs.getDate(4);
//				test1Vo vo= new test1Vo(n, name, tel, d);
//				return vo;
				//한번에묶어서 쓰면?
				return new test1Vo(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getDate(4));
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
		return null; //없으면 null반환
		
	}
	
	//수정. 번호로 찾아서 이름과 전화번호를 수정
	//update 테이블명 set 컬럼명=() where(조건추가)
	public void update(test1Vo vo) {
		String sql = "update test1 set name=?, tel=? where num=?";
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTel());
			pstmt.setInt(3, vo.getNum());
			pstmt.executeUpdate(); //실행
			
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
	
	//삭제 동일한 번호를 찾아서 삭제
	public void delete(int num) {
		String sql = "delete from test1 where num=?";
		
		Connection conn = dbconn.conn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, num);
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
	
	//전체검색 : 여러줄이검색이 되기때문에 반환타입이 arraylist여야함!
	//테이블 한줄이 vo하나다. 숫자 오름차순으로 나오게
	public ArrayList<test1Vo> selectAll() { //파라메터는 필요없음
		String sql = "select*from test1 order by num asc"; //숫자활용한 오름차순 
		
		ArrayList<test1Vo> list = new ArrayList<>();
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//셀렉트실행시 ResultSet 반환
			ResultSet rs = pstmt.executeQuery();
			//여러줄이니까 while. rs.next로 줄넘기면서~~
			while(rs.next()) {
				list.add(new test1Vo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4)));			
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
	
	//전화번호 패턴 매칭(전화번호에 3이들어가는거 다찾기)
	//여러개가 나올수있기때문에 반환타입 arraylist이고, 전화번호기준 : 파라메터 tel.
	//오라클 like란 ->
	public ArrayList<test1Vo> selectByTel(String tel){
		String sql = "select*from test1 where tel like ?";
		
		ArrayList<test1Vo> list = new ArrayList<>();
		Connection conn = dbconn.conn();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//셀렉트실행시 ResultSet 반환
			pstmt.setString(1, tel); 
			ResultSet rs = pstmt.executeQuery();
			//여러줄이니까 while. rs.next로 줄넘기면서~~
			while(rs.next()) {
				list.add(new test1Vo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4)));			
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
}
