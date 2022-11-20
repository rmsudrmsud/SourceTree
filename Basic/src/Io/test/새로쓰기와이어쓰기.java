//11월2일
package Io.test;

import java.io.FileWriter;
import java.io.IOException;

public class 새로쓰기와이어쓰기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//새로쓰기모드 
//			FileWriter out = new FileWriter("src/Io/test/Files/d.txt");
//			out.write("기존 내용을 삭제하고 쓰는 새로쓰기 모드");
//			out.close();
			
			//이어쓰기모드 . 쓰기 스트림의 2번째 파람이 append모드(ture : 이어쓰기, false : 새로쓰기모드(default포함))
			FileWriter out = new FileWriter("src/Io/test/Files/d.txt", true);
			out.write("\n이어쓰기 모드. 기존 내용 뒤에 이어짐.");
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
