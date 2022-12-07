package Io.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class FileInputStreamTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		//String path = 파일의 절대경로~
		int ch;
		FileInputStream fi;
		try {
			fi = new FileInputStream("src/Io/test/Files/a.txt");
			
			//파일에서 읽은 데이터를 저장할 바이트 배열 생성.
			byte[] datas = new byte[10];
			//read(바이트 배열) : 배열의 크기만큼 읽어서 배열에 저장하고 읽은 바이트 수 반환.
			while((ch = fi.read(datas))>0) { //읽는바이트수가 0보다 클동안 읽은 데이터를 ch에 저장.
				//배열의 크기보다 작게 읽었을때
				if(ch<datas.length) {
					for(int i = ch; i< datas.length; i++) {
						datas[i] = (byte) ' ';
					}
				}
				System.out.println("읽은 바이트 수 : "+ ch);
				System.out.println(new String(datas)); //new String(datas) : 바이트 배열에있는 값들을 String 문자열로 변환해서 출력.
				System.out.println("====");
			}
			fi.close();	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
