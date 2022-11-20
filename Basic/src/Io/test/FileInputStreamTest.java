package Io.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FileInputStream : 파일로부터 1바이트씩 읽는 스트림
		try {
			FileInputStream fi = new FileInputStream("src/Io/test/Files/a.txt"); //생성자 읽을 파일 경로 지정. 예외처리. 상대경로.
			
			int ch;
			while((ch = fi.read())!= -1) { //-1 : 파일의 끝을 나타내는 상수
				System.out.print((char)ch);
			}
			fi.close(); //사용한 스트림 닫기.
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
