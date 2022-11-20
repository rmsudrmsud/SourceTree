package oop1;



import java.util.Scanner; // 현재클래에서 자바유틸패키지에있는 스캐너를 사용한다는 뜻



//캡슐화

//vo(value object)-객체별로 묶. dto(data transfer object) 클래스. 값(데이터)을 담는 객체

class Person {

	String name; // 멤버변수

	String tel;

	String address;



	// 생성자

	Person() {

	}


	Person(String name, String tel, String address) { // name tel address 지역변수

		this.name = name; // this 지역변수와 멤버변수 이름이같아서 구분하기위해 사용

		this.tel = tel; // 현재의 tel 에 파라메터 tel값을 넣어라.

		this.address = address;

	}



	void printPerson() {

		System.out.println("name: " + name);

		System.out.println("tel: " + tel);

		System.out.println("address: " + address);

	}

}



//dao(database access object)클래스 : db처리전담

//배열에 Person을 추가, 검색, 삭제 작업 전담

class PersonDao {

	// Person 객체 담을 배열

	Person[] datas;

	int cnt; // Person객체의 개수 카운팅 할 변수. 방의 갯수와 담긴객체의 수가다르니까



	// 생성자

	PersonDao() {

		datas = new Person[30];

	}



	// 배열에 새 Person객체를 추가

	void insert(Person p) { // p: 새 이름, 전화, 주소 들어있음. Person(vo)클래스를 파라메터로

		if (cnt >= datas.length) { // 배열이 가득 찼나 체크

			System.out.println("가득찼습니다");

			return; // return 값이 없으면 현재 메서드에서 종료

		}

		datas[cnt++] = p; // datas에 cnt위치에 p객체 저장(누적) 이후 cnt++

	}



	// 이름으로 검색. 있으면 검색된 객체를, 없으면 null을 반환

	Person select(String name) { // 검색할 이름 파라메터로 받기

		for (Person p : datas) { // 앞에서부터 person객체 꺼내기

			if (p == null)

				break;

			if (name.equals(p.name)) { // 꺼낸 객체의 이름과 파라메터로받은 이름이 같은가

				return p;

			} // else {return null;} 가없는 이유: 이곳에 있으면 검색하나하고 바로 없다가나옴.

			// 끝까지 for문을 다돌아야 하기때문에 for문 바깥쪽에 return.

		}

		return null; // for문 다돌고 같은이름을 찾지못하면 null 출력

	}



	// select2 : 이름으로 검색해서 인덱스(방번호) 반환

	int select2(String name) { // 방번호가 숫자임으로 int

		for (int i = 0; i < cnt; i++) {

			if (datas[i].name.equals(name)) {

				return i;

			}

		}

		return -1; // -1 : 방번호에 음수가 없으니까 없는경우 -1로 표시한다는 뜻. -5, -10 상관x

	}



	// 이름으로 검색해서 삭제

	void delete(String name) {

		// 1. 이름으로 위치 찾음 select2 호출

		int idx = select2(name); // 삭제할 위치찾기

		if (idx < 0) {

			System.out.println("not found. 삭제취소");

			return;

		}

		// 2. 검색된 이름 위치 방을 삭제 : 삭제할 방 뒤의 모든 객체를 한칸씩 앞으로 이동하기

		for (int i = idx; i < cnt; i++) {

			datas[i] = datas[i + 1];

		}

		// 3. cnt 1감소

		cnt--;

	}


}



//service클래스 : 비즈니스 로직 구현. 사용자에 기능 제공.보통 멤버변수로 dao클래스 사용

class PersonService {



	PersonDao dao;



	PersonService() {

		dao = new PersonDao();

	}


	// 추가

	void addPerson(Scanner sc) { // Scanner 빨간줄 뜨는이유 : Scanner 클래스를 현재 패키지에서

		// 찾는데 없어서 . 컨트롤+쉬프트+O -> import사용. 패키지까지풀네임 너무길어서 불편

		// void addPerson(java.util.Scanner Sc) -> 현재클래스가 아닌

		// 자바유틸에 스캐너있는거 사용

		System.out.println("새 주소 추가");

		String name = ""; // String의 초기값 null 이지만 ""로 쓰기도함

		while (true) {

			// 이름 입력

			System.out.print("name:");

			name = sc.next();

			// 이름 중복체크

			Person p = dao.select(name);

			if (p == null) {// 중복안됨


				break;

			} else {



				System.out.println("중복된 이름. 다시입력하시오");

			}

		}



		System.out.println("tel:");



		String tel = sc.next();

		System.out.println("address:");

		sc.nextLine();// nextLine을 사용할때에만 입력버퍼에 남은 엔터 제거하기위해 한번더 사용

		String address = sc.nextLine();

		dao.insert(new Person(name, tel, address));

	}



	// 검색. 검색할 사람 이름 정보받아 출력

	void searchPerson(Scanner sc) {

		System.out.println("이름으로 검색");

		//검색할 이름 입력

		System.out.println("name:");

		String name = sc.next();



		//이름 중복체크

		Person p = dao.select(name);

		if (p == null) {// 중복안됨

			System.out.println("없는이름");

		} else {

			p.printPerson();

		}

	}


	// 수정

	void editPerson(Scanner sc) {

		System.out.println("수정");

		//수정할 이름 입력

		System.out.println("edit name:");

		String name = sc.next();



		//이름 중복체크

		Person p = dao.select(name);

		if (p == null) {// 중복안됨

			System.out.println("없는이름");

		} else {

			System.out.println("수정전 정보");

			p.printPerson();

			System.out.println("new tel:");

			p.tel = sc.next(); //방위치 확인 없이 다이렉트로 가서 수정

			System.out.println("new address:");

			sc.nextLine();

			p.address = sc.nextLine();

		}

	}

	// 삭제

	void delPerson(Scanner sc) {

		System.out.println("삭제");

		//삭제할 이름 입력

		System.out.println("del name");

		String name = sc.next();



		//배열에서 삭제

		dao.delete(name);

	}

	// 전체출력

	void printAll() {

		for (int i = 0; i < dao.cnt; i++) {

			dao.datas[i].printPerson();

		}

	}

}



//ui 대용. 메뉴 돌림

class Menu {

	// 사용자가 원하는 기능 제공. 기능 구현한 서비스 클래스

	PersonService service;



	// 생성자. 이름이 클래스와같고 반환값이없다 - 생성자의역할 : 객체초기화

	Menu() {

		service = new PersonService();

	}



	// 메뉴 실행 메서드

	void run(Scanner sc) {

		boolean flag = true;

		int m = 0;

		while (flag) {

			System.out.println("1.추가 2.검색 3.수정 4.삭제 5.전체출력 6.종료");

			m = sc.nextInt();

			switch (m) {

			case 1:

				service.addPerson(sc);

				break;

			case 2:

				service.searchPerson(sc);

				break;

			case 3:service.editPerson(sc);

			break;

			case 4:service.delPerson(sc);

			break;

			case 5:

				service.printAll();

				break;

			case 6:

				flag = false;

				break;

			}

		}

	}

}



public class ThisTestMain {



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		Menu m = new Menu();

		m.run(sc);



		// Scanner sc = new Scanner(System.in);

		// String str = sc.next(); // 단어한개(스페이스x)

		// int x = sc.nextInt(); // 정수한개

		// sc.nextLine();  // nextLine을 사용할때에만 입력버퍼에 남은 엔터 제거하기위해 한번더 사용

		// String line = sc.nextLine(); //스페이스를 포함한 한줄

		// 

		// System.out.println(str);

		// System.out.println(x);

		// System.out.println(line);

		// 

		// Person[] arr = new Person[10]; // 방 10개. Person 객체는 0개

		// arr[1] = new Person("bbb","222","qerads");

		// arr[2] = new Person("ccc","333","asdfee");

		// for(Person p:arr) { // for(Person p:arr) 배열의 길이만큼 for

		// if (p==null) {

		// break;

		// }

		// p.printPerson();

		// }

	}



}