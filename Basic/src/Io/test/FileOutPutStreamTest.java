package Io.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutPutStreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//절대경로!
		String path = "/Users/choigeunhyeong/Documents/Kosta/Basic/src/Io/test/Files/b.txt"; // 절대경로 커맨드+옵션+c 로 따오고 마지막에 /b.txt
		//하면 없던 b.txt가 생기고 왼쪽 Io.test에서 리프레시 버튼 누르면 b가 생김!
		try {
			//FileOutputStream: 파일에 바이트 단위로 출력 스트림.
			FileOutputStream fo = new FileOutputStream(path);
			//문자열.getBytes() : 문자열을 바이트 배열로 변환.
			byte[] datas = "hello io".getBytes();
			fo.write(datas);
			fo.close();
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
