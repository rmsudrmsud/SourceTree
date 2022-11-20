//11월 4
package 복습;

import java.util.Scanner;

//사용자가 원하는 기능을 제
public class Menu {
	private Service service;
	
	public Menu() {
		service = new Service();
	}
	
	public void run(Scanner sc) {
		boolean flag = true; //루프제어
		int m;
		while(flag) {
			System.out.println("1수강신청 2. 검색 3. 수정 4.삭제 5.전체출력 6.종료");
			m = sc.nextInt();
			switch(m) {
			case 1:
				service.add(sc);
				break;
			case 2:
				service.print수강(sc);
				break;
			case 3:
				service.edit수강(sc);
				break;
			case 4:
				service.delete수강(sc);
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
