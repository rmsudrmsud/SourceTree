package Io.test;
//11월 2일

import java.io.BufferedReader;
import java.io.BufferedWriter;
//과제 파일복사
//원폰파일경로, 복사할파일경로 입력받아서 
//원본의 내용을 타깃 파일에 복사하고 끝내기.
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class MyCopy {
	private String srcPath; // 원본파일 경로
	private String destPath; // 복사될 타깃 파일 경로.

	public MyCopy() {
	}

	public MyCopy(String srcPath, String destPath) {
		this.srcPath = srcPath;
		this.destPath = destPath;
	}

	public String getSrcPath() {
		return srcPath;
	}

	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}

	public String getDestPath() {
		return destPath;
	}

	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}

	public void copy() {
		try {
//			FileReader fr = new FileReader(srcPath); 기본스트림 
//			FileWriter fw = new FileWriter(destPath);
		BufferedReader  fr = new BufferedReader(new FileReader(srcPath)); //보조스트림 + 기본스트림 
		BufferedWriter  fw = new BufferedWriter(new FileWriter(destPath));
			int ch;
			while ((ch = fr.read()) != -1) {
				fw.write(ch); // 복사
			}
			fr.close();
			fw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

public class CopyTest {
	public static void main(String[] args) {
		MyCopy mc = new MyCopy("src/Io/test/CopyTest.java", "src/Io/test/Files/CopyTest_copy.txt");
		mc.copy();
	}
}
