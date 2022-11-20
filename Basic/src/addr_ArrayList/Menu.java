package addr_ArrayList;
//11월 2일 기존 ArrayList에 보조스트림 추가.종료해도 이전기록이 저장되어 남음
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	// 사용자가 원하는 기능 제공. 기능 구현한 서비스 클래스
	private PersonService service;
	private String path;

	// 생성자
	public Menu() {
		service = new PersonService(new DaoImplEqls());// 의존성 주입
		path = "addr_data.dat";
	}

	// 파일에 저장된 객체를 ArrayList에 복구
	public void start() {
		// 파일 정보 클래스
		File f = new File(path);
		if (!f.exists()) { // exists(): 파일 존재하면 true, 아니면 false
			System.out.println("읽을 데이터 없음");
			return;
		}
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));

			Person p = null;
			while (true) {
				p = (Person) in.readObject();
				if (p == null) {
					break;
				}
				service.add(p);
			}
			in.close();
			System.out.println("복구완료");
		} catch (EOFException e) {
			// TODO Auto-generated catch block

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	// 프로그램 종료 전에 호출. ArrayList 데이터를 파일에 저장
	public void stop() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));

			ArrayList<Person> list = service.getAll();
			for (Person p : list) {
				oos.writeObject(p);
			}

			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 메뉴 실행 메서드
	public void run(Scanner sc) {
		boolean flag = true;
		int m = 0;
		// 프로그램 시작시 파일에서 객체들을 읽어서 ArrayList에 추가
		start();
		// 프로그램 끝나기 전 ArrayList의 모든 객체를 파일에 써라
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
		stop();
	}
}
