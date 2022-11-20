//11월 3일.
package memo;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String path = "./memo/"; // 프로젝트 밑에 memo 디렉토리
		Menu m = new Menu(path);
		m.run(sc);
	}

}