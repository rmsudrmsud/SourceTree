package Io.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderTest {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("src/Io/test/Files/c.txt");
			int ch;
			
				while((ch=fr.read())!=-1) {
					System.out.print((char)ch);
				}
				fr.close();

			} catch(FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		
		
	}
}