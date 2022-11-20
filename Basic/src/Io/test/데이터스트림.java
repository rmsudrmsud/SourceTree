package Io.test;
//11월 2
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class 데이터스트림 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//데이터 타입별 출력 스트림.
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/Io/test/Files/datastream.dat")); //.dat 프로그램에서 다이너리형태로 데이터 보관
			dos.writeByte(10);
			dos.writeDouble(23.4465);
			dos.writeChars("asf");
			dos.close();
			
			DataInputStream dis = new DataInputStream(new FileInputStream("src/Io/test/Files/datastream.dat"));
			byte a = dis.readByte();
			double b = dis.readDouble();
			String c = dis.readLine();
			dis.close();
			System.out.println("a:"+a);
			System.out.println("b:"+b);
			System.out.println("c:"+c);
		}  
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
