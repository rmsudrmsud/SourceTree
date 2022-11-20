package addr;

import java.util.Scanner;

public class Menu {
	// 사용자가 원하는 기능 제공. 기능 구현한 서비스 클래스
	PersonService service;

	// 생성자
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
			case 3:
				service.editPerson(sc);
				break;
			case 4:
				service.delPerson(sc);
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