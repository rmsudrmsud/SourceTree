package except_test;

import java.io.IOException;

class Test2{
	public void test1() throws IOException {  // 예외 처리 미룸. System.in.read를 쓰려면 IOException이필요했음.
		int ch = ' ';
		while((ch = System.in.read()) != '\n'){ //System.in 표준입력.byte 단위로 읽어 한글입력시 깨짐. read()한번에 한개씩?
			System.out.println((char)ch);
		}
	}
}
public class 예외미루기 {

	public static void main(String[] args)  {
		Test2 t2  = new Test2(); 
		try{ //호출하는 쪽에서 예외처리하겠다.
			t2.test1();
		}catch(IOException e) {
			e.printStackTrace();  
		}
	}

}
