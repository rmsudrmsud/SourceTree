//11월 3일 
package memo;

import java.util.Scanner;

public class Menu {
	private service service;
	
	public Menu(String path) {
		service = new service(path);
	}
	
	public void run(Scanner sc) {
		boolean flag = true;
		int m = 0;
		while(flag) {
			System.out.println("1.읽기 2.쓰기 3.삭제 4.종료");
			m = sc.nextInt();
			switch(m) {
			case 1:
				service.readFile(sc);
				break;
			case 2:
				service.writeFile(sc);
				break;
			case 3:
				service.delFile(sc);
				break;
			case 4:
				flag = false;
				break;
			}
		}
	}
}