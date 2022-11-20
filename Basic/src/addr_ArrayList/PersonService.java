package addr_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonService {
	//인터페이스타입 : dao 객체 교체 가능
	private Dao dao;
	
	//생성자로 의존성 주입 
	public PersonService(Dao dao) { //(Dao dao) 인터페이스 연결하는 부품역할 하는자리!(변경하기쉽게) 
		// dao 객체 생성 
		this.dao = dao;
	}
	
	//setter로 의존성 주입 
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	public void add(Person p) {
		dao.insert(p);
	}

	// 추가
	public void addPerson(Scanner sc) {
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
	public void searchPerson(Scanner sc) {
		System.out.println("이름으로 검색");
		//검색할 이름 입력
		System.out.print("name:");
		String name = sc.next();
		
		// 이름 중복체크
		Person p = dao.select(name);
		if (p == null) {// 중복안됨
			System.out.println("없는 이름");
		} else {
			System.out.println(p);
		}
	}

	// 수정
	public void editPerson(Scanner sc) {
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
			System.out.println(p);
			System.out.print("new tel:");
			p.setTel(sc.next());
			System.out.print("new address:");
			sc.nextLine();
			p.setAddress(sc.nextLine());
		}
	}

	// 삭제
	public void delPerson(Scanner sc) {
		System.out.println("삭제");
		//수정할 이름 입력
		System.out.print("del name:");
		String name = sc.next();
		
		// 배열에서 삭제
		dao.delete(name);
	}

	// 전체출력
	public void printAll() {
		System.out.println("주소 목록");
		ArrayList<Person> list = dao.selectAll();
		for(Person p:list) {
			System.out.println(p);
		}
	}
	
	//전체검색 
	public ArrayList<Person> getAll(){
		return dao.selectAll();
	}
}