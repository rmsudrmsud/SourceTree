//11월2일 
package Io.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class 파일 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// File : 파일 정보 및 제어 클래스
		File f = new File("src/Io/test/Files/filetest.txt");
		if (!f.exists()) { // exists() 파일 존재유무 확인
			System.out.println("파일생성 ");
			try {
				f.createNewFile(); // 파일생성 쓰기모드로 할때는 생성하지않아도 알아서 생김
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		if (f.canRead()) { // 읽기 가능? true/false
			System.out.println("읽기 가능파일 ");
		}

		if (f.canWrite()) { // 쓰기 가능? true/false
			System.out.println("쓰기 가능파일 ");
		}

		if (f.canExecute()) { // 실행 가능? true/false
			System.out.println("실행 가능파일 ");
		}
		
		// 디렉토리 제어
		String path = "src/Io/test/Files/memo/"; // Files밑에 memo라는 디렉토리를만들고싶을때. 디렉토리도 파일과같다.
		File dir = new File(path);
		if (!dir.exists()) { // "src/Io/test/Files/memo/"경로에 디렉토리가 있느냐
			dir.mkdir(); // 디렉토리 생성.
		}

		for (int i = 0; i < 3; i++) {
			try {
				FileWriter fw = new FileWriter(path + i + ".txt");
				fw.write("hello" + i + "txt");
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		String[] files = dir.list();// memo 디렉토리 아래의 파일목록 반환. [0.txt, 1.txt, 2.txt]
		for (String ff : files) {
			System.out.println("파일명:" + ff);
			try {
				FileReader fr = new FileReader(path + ff);
				char[] buf = new char[50];
				fr.read(buf);
				System.out.println(buf);
				fr.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

//		//파일삭제
//		for (String ff : files) {
//			File delFile = new File(path + ff);
//			if(delFile.exists()) {
//				delFile.delete(); //파일 삭제 
//			}
//		}
	}

}
