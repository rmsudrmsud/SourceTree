//11월 2일
package Io.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

 
public class RandomAccessTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//RandomAccess 내가 원하는위치로 점프해서 값을 읽고싶을 때 
			//RandomAccessFile f = new RandomAccessFile("경로","모드");
			RandomAccessFile f = new RandomAccessFile("src/Io/test/Files/a.txt", "r"); //r : 읽기모드 rw 읽고쓰기모드 등
			//맨 앞 한바이트 읽음.
			int ch = f.read();
			System.out.println("0위치의 값:"+(char)ch);
			//원하는 위치로 이동. 
			f.seek(4);
			ch = f.read();
			System.out.println("4위치의 값:"+(char)ch);
			System.out.println("파일의 크기"+f.length());
			System.out.println("=========");
			//뒤에서부터 읽게하려면?
			long size = f.length(); //파일의 크기값을 읽기 
			for(int i=1; i<=size; i++) {
				f.seek(size-i); //맨뒤에서부터. for문 으로 한자리씩 
				ch = f.read();
				System.out.print((char)ch);
			}
			f.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
