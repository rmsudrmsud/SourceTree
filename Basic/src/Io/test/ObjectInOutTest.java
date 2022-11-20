//11월 2일 
package Io.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//Serializable 상속 : 직렬화 처리
//직렬화 : 객체를 다른 프로그램에 전달시 참조값만 보내면 다 메모리에는 그 주소에 객체가 없다.
//그래서 객체의 멤버변수 값을 하나씩 전달하는 것이 직렬화.

class Person implements Serializable{  //Serializable -> 직렬화 처리
	private String name;
	private int age;
	
	public Person() {
	}
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}

public class ObjectInOutTest { //객체 단위로 읽고 쓰기 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Io/test/Files/obj_test.dat"));
			
			Person p1 = new Person("aaa", 12);
			Person p2 = new Person("bbb", 23);
			
			//파일에 객체 2개 작
			oos.writeObject(p1);
			oos.writeObject(p2);
			
			oos.close();
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Io/test/Files/obj_test.dat"));
			
			Person p3 = (Person)ois.readObject(); //readObject 는 원래형태?로 읽어오기 때문에 다운캐스팅해줘야함
			Person p4 = (Person)ois.readObject();
			ois.close();
			
			System.out.println("p3:"+p3);
			System.out.println("p4:"+p4);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
