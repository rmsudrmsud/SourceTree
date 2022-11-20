package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class test1Service {
	
	public test1Dao dao = new test1Dao();
	//추가
	public void add(Scanner sc) {
		System.out.println("===추가===");
		System.out.println("num:");
		int num = sc.nextInt();
		System.out.println("name:");
		String name = sc.next();
		System.out.println("tel:");
		String tel = sc.next();
		
		test1Vo vo =new test1Vo(num,name,tel,null);
		dao.insert(vo);
	}
	
	//번호로 검색
	public void printNum(Scanner sc) {
		System.out.println("===번호로 검색===");
		System.out.println("검색할 번호:");
		int num = sc.nextInt();
		test1Vo vo = dao.select(num);
		if(vo==null) {
			System.out.println("없는 번호");
		}else {
			System.out.println(vo);
		}
	}
	
	//수정 번호로찾아서 이름과 전화번호 수정
	public void update(Scanner sc) {
		System.out.println("=== 수정 ===");
		System.out.println("수정할 num:");
		int num = sc.nextInt();
		System.out.println("name:");
		String name = sc.next();
		System.out.println("tel");
		String tel = sc.next();
		test1Vo edit = new test1Vo(num,name,tel,null);
		dao.update(edit);
	}
	//삭제
		public void delete(Scanner sc) {
			System.out.println("=== 삭제 ===");
			System.out.println("삭제할 num:");
			int num = sc.nextInt();
			dao.delete(num);
		}
	//전체출력
		public void printAll() {
			System.out.println("=== 전체검색 ===");
			ArrayList<test1Vo> list = dao.selectAll();
			for (test1Vo x : list) {
				System.out.println(x);
			}
		}
	//전화번호 패턴매칭 . arrayList이용
		public void selectTel(Scanner sc){
			System.out.println("=== 번호로검색 ===");
			System.out.println("검색할 번호:");
			String tel = sc.next();
			ArrayList<test1Vo> list = dao.selectByTel("%"+tel+"%");
			for (test1Vo x : list) {
				System.out.println(x);
			}
		}
}
