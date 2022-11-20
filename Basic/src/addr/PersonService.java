package addr;

import java.util.Scanner;

public class PersonService {
	PersonDao dao;

	// 생성자
	PersonService() {
		// dao 객체 생성
		dao = new PersonDao();
	}

	// 추가
	void addPerson(Scanner sc) {
		System.out.println("새 주소 추가");
		String name = "";
		while (true) {
			// 이름 입력
			System.out.print("name:");
			name = sc.next();
			// 이름 중복체크
			Person p = dao.select(name);
			if (p == null) {// 중복안됨
				break;
			} else {
				System.out.println("중복된 이름. 다시 입력하시오");
			}
		}
		System.out.print("tel:");
		String tel = sc.next();
		System.out.print("address:");
		sc.nextLine();// 입력버퍼에 남은 엔터 삭제
		String address = sc.nextLine();
		dao.insert(new Person(name, tel, address));
	}

	// 검색. 검색할 사람 이름 입력받아 정보 출력
	void searchPerson(Scanner sc) {
		System.out.println("이름으로 검색");
		//검색할 이름 입력
		System.out.print("name:");
		String name = sc.next();
		
		// 이름 중복체크
		Person p = dao.select(name);
		if (p == null) {// 중복안됨
			System.out.println("없는 이름");
		} else {
			p.printPerson();
		}
	}

	// 수정
	void editPerson(Scanner sc) {
		System.out.println("수정");
		//수정할 이름 입력
		System.out.print("edit name:");
		String name = sc.next();
		
		// 이름 중복체크
		Person p = dao.select(name);
		if (p == null) {// 중복안됨
			System.out.println("없는 이름");
		} else {
			System.out.println("수정전 정보");
			p.printPerson();
			System.out.print("new tel:");
			p.tel = sc.next();
			System.out.print("new address:");
			sc.nextLine();
			p.address = sc.nextLine();
		}
	}

	// 삭제
	void delPerson(Scanner sc) {
		System.out.println("삭제");
		//수정할 이름 입력
		System.out.print("del name:");
		String name = sc.next();
		
		// 배열에서 삭제
		dao.delete(name);
	}

	// 전체출력
	void printAll() {
		System.out.println("주소 목록");
		for (int i = 0; i < dao.cnt; i++) {
			Person p = dao.datas[i];
			p.printPerson();
		}
	}
}