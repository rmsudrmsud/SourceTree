package Io.test;
//11월 2일 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		try {
			//FileWriter : 문자단위(2바이트) 출력 스트
			FileWriter fw = new FileWriter("src/Io/test/Files/d.txt"); //미리안만들어도 출력용이라 d 자동ㅇ생성됨.
			while(true) {
				System.out.println("내용입력. 멈추려면 /stop");
				String str = sc.nextLine();
				if(str.startsWith("/stop")) {
					break;
					}
				fw.write(str + "\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
