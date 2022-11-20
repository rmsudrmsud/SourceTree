//11월3일 
package memo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class service {
	// 메모장을 저장할 디렉토리 경로
	private String path;// path = ./memo/

	public service(String path) {
		this.path = path;
	}

	public void mkdir() {
		// 파일, 디렉토리 정보 클래스
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();// 디렉토리 생성
			// getAbsolutePath(): 파일의 절대경로를 반환
			System.out.println(dir.getAbsolutePath() + " 디렉토리 생성됨");
		}
	}

	// 메모 디렉토리의 파일 목록을 출력
	public String printFileList(Scanner sc) {
		File dir = new File(path);
		// list(): 디렉토리에 속한 파일들의 이름 ["a.txt", "b.txt"]
		String[] files = dir.list();
		System.out.println("파일 목록");
		for (int i = 0; i < files.length; i++) {
			System.out.println(i + ". " + files[i]);
		}

		// 읽고싶은 파일의 번호를 입력하면 그 파일의 이름을 반환
		// 입력 값은 0~배열길이
		int num;
		while (true) {
			System.out.println("원하는 파일 번호 입력:");
			num = sc.nextInt();
			if (num < 0 || num >= files.length) {
				System.out.println("잘못된 번호. 다시 입력하시오");
			} else {
				break;
			}
		}
		return files[num];
	}

	// 파라메터로 받은 파일명을 오픈해서 내용 읽어 출력
	public void readFile(Scanner sc) {
		System.out.println("읽을 파일 선택하시오");
		String fname = printFileList(sc);
		try {
			// 1. 읽기 스트림 생성
			FileReader fr = new FileReader(path + fname);// ./memo/a.txt

			// 2. read() 읽음
			int ch;
			while ((ch = fr.read()) != -1) {// -1: 파일의 끝
				// 3. 읽은 값 출력
				System.out.print((char) ch);
			}

			// 4. 스트림 닫음
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 파일명 중복 체크
	// param1:비교파일명, param2:메모파일목록
	public boolean fnameCheck(String fname, String[] files) {
		for (String f : files) {
			if (f.equals(fname)) {
				return true;
			}
		}
		return false;
	}

	public String[] inputFileName(Scanner sc) {
		File dir = new File(path);
		// 메모 디렉토리의 파일 목록
		String[] files = dir.list();
		String mode = "w"; // mode(쓰기모드):새로쓰기(w), 이어쓰기(a)
		boolean flag = false;
		int m;
		String fname = "";
		while (true) {
			System.out.print("파일명:");
			fname = sc.next();
			// 입력한 파일명의 중복체크
			flag = fnameCheck(fname, files);
			if (flag) {// 파일명 중복됨
				System.out.println("1.새파일명입력 2.덮어쓰기 3.이어쓰기");
				m = sc.nextInt();
				if (m == 1) {
					continue;
				} else if (m == 2) {
					break;
				} else if (m == 3) {
					mode = "a";
					break;
				}
			} else {
				break;// 중복이 안됐으면 루프 빠져나감
			}
		}
		return new String[] { fname, mode };
	}

	public void writeFile(Scanner sc) {
		// res[0]:파일명, res[1]:모드
		String[] res = inputFileName(sc);
		boolean flag = false;// flag: 쓰기 모드(false:덮어쓰기 / true:이어쓰기)
		if (res[1].equals("a")) {
			flag = true;
		}

		try {
			FileWriter fw = new FileWriter(path + res[0], flag);
			String content = "";
			while (true) {
				System.out.print("content(멈추려면 /stop):");
				content = sc.nextLine();
				if (content.length() == 0) {
					continue;
				}
				if (content.startsWith("/stop")) {
					break;
				}
				fw.write(content + "\n");
			}

			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delFile(Scanner sc) {
		System.out.println("삭제할 파일 선택하시오");
		String fname = printFileList(sc);
		File f = new File(path + fname);
		f.delete();// 파일 삭제
	}
}