//11월 4일
package 복습;

import java.util.ArrayList;
import java.util.Scanner;

public class Service {
	Scanner sc = new Scanner(System.in);
	public 수강Dao dao = new 수강Dao();

	// 추가 메서드 add()반환타입 void 파람: 스캐너
	public void add(Scanner sc) {
		System.out.println("===추가===");
		System.out.println("code:");
		int code = sc.nextInt();
		System.out.println("name:");
		String name = sc.next();
		System.out.println("prof name:");
		String pname = sc.next();
		System.out.println("cnt:");
		int cnt = sc.nextInt();
		System.out.println("room:");
		String room = sc.next();

		수강 sugang = new 수강(code, name, pname, cnt, room);
		dao.insert(sugang);
	//	dao.insert(new 수강(code, name, pname, cnt, room)); //위의코드 2줄하나로합치면 요기 
	}
	
	//검색
	public void print수강(Scanner sc) {
		System.out.println("====code로 검색====");
		System.out.println("검색할 code:");
		int code = sc.nextInt();
		int idx = dao.select(code); //0번째방
		if(idx<0) {
			System.out.println("없는 코드");
		}else {
		수강 res = dao.selectByIdx(idx); // 방번호로 객체꺼내오기
		res.printData();
		}
	}
	
	//수정
	public void edit수강(Scanner sc) {
		//수정할 수강코드, 새 교수명, 새 강의장 입력받는다
		//입력받은 값을 수강 객체에 저장
		System.out.println("===수정===");
		System.out.println("수정할 code:");
		int code = sc.nextInt();
		System.out.println("새 교수명");
		String newprof = sc.next();
		System.out.println("새 강의실");
		String room = sc.next();
		수강 edit = new 수강(code,"", newprof,0,room);
		dao.update(edit);
	}
	
	//삭제
	public void delete수강(Scanner sc) {
		System.out.println("===삭제===");
		System.out.println("삭제할 code:");
		int code = sc.nextInt();
		dao.delete(code);
	
		
	}

	// 전체검색 메서드 printAll
	public void printAll() {
		System.out.println("===전체검색===");
		ArrayList<수강> list = dao.selectAll();
		for (수강 x : list) {
			x.printData();
		}
		
		
	}
}
