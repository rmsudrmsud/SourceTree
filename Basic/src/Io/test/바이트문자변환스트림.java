package Io.test;
//11월 2일 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 바이트문자변환스트림 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int ch;
		try {
			while((ch=in.read())!= '\n') {
				System.out.print((char)ch);
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
