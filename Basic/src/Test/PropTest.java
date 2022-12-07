package Test;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

public class PropTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		prop.put("ip", "192.168.0.123");
		prop.put("port", "5000");
		prop.put("id", "scott");
		prop.put("pwd", "tiger");
		
		System.out.println("ip:"+prop.getProperty("ip"));
		System.out.println("port:"+prop.getProperty("port"));
		System.out.println("id:"+prop.getProperty("id"));
		System.out.println("pwd:"+prop.getProperty("pwd"));
		
		//키묶음(ip, port,id, pwd)에 연결된 반복자 생성 keyset:중복허용x,순서없는 집합 
		Iterator iter = prop.keySet().iterator();
		while(iter.hasNext()){ //hasNext:다음 읽을값이 있는가. 있으면 true 없으면 false
			//iter.next() : 다음값 하나추출
			String key = (String)iter.next();
			System.out.print(key+":");
			System.out.println(prop.getProperty(key));
		}
		Properties prop2 = new Properties();
		try {
			//prop.store(new FileWriter("test.properties"),"coment"); //coment: 설명, FileWriter : 파일생성
			prop2.load(new FileReader("test.properties"));
			System.out.println("파일로드내용");
			Iterator iter2 = prop2.keySet().iterator();
			while(iter2.hasNext()){ //hasNext:다음 읽을값이 있는가. 있으면 true 없으면 false
				//iter.next() : 다음값 하나추출
				String key = (String)iter2.next();
				System.out.print(key+":");
				System.out.println(prop.getProperty(key));
			}
			prop2.storeToXML(new FileOutputStream("test.xml"), "prop2 comment");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
