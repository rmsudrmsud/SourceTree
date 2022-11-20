package Io.test;
//11월 2일
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//기본 스트림 생성
			FileInputStream fi = new FileInputStream("src/Io/test/Files/a.txt");
			
			//보조 스트림 연결
			BufferedInputStream bi = new BufferedInputStream(fi);
			
			int ch;
			while((ch=bi.read())!=-1) {
				System.out.print((char)ch);
			}
			
			bi.close();
			fi.close();
			
			//FileOutputStream에 buffer보조 스트림 연결
			BufferedOutputStream bo = 
					new BufferedOutputStream(
					new FileOutputStream("src/Io/test/Files/buf.txt"));
			
			//FileReader에 buffer보조 스트림 연결
			BufferedReader br = 
					new BufferedReader(
							new FileReader("src/Io/test/Files/a.txt"));
			
			//FileWriter buffer보조 스트림 연결
			BufferedWriter bw = 
					new BufferedWriter(
							new FileWriter("src/Io/test/Files/buf.txt"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
