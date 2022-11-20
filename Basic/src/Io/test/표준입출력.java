package Io.test;
//2022 11월 1일

import java.io.IOException;

public class 표준입출력 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ch = ' ';
		try {
		while((ch=System.in.read())!='\n') { //System.in표준입력스트림. System클래스에 InputStream. read :키보드에서 1byte 씩 읽어옴.
			System.out.print((char)ch); //System.out 표준 출력트림.
		}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}

