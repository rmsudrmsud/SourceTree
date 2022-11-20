package test;

import java.util.Scanner;

public class Menu {
private test1Service service = new test1Service();
	
	public Menu() {
		service = new test1Service();
	}
	
	public void run(Scanner sc) {
		boolean flag = true; //루프 제어
		int m;
		while(flag) {
			System.out.println("1.추가 2.번호검색 3.수정 4.삭제 5.전체출력 6.번호매칭검색 7.종료");
			m = sc.nextInt();
			switch(m) {
			case 1:service.add(sc);
				break;
			case 2:service.printNum(sc);
				break;
			case 3:service.update(sc);
				break;
			case 4:service.delete(sc);
				break;
			case 5:service.printAll();
				break;
			case 6:
				service.selectTel(sc);
				break;
			case 7:
				flag = false;
				break;
			}
		}
	}
}
