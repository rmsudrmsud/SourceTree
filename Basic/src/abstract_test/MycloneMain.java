package abstract_test;

import java.lang.reflect.Field;

//clone()메서드를 사용하려면 Cloneable 인터페이스 상속받고
//clone()을 재정의 해야함
class Myclone implements Cloneable{//객체를 복사하는 메서드
	
	public String name;
	public int age;
	
	public Myclone(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException { //throws 예외처리를 미룸
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		return "Myclone [name=" + name + ", age=" + age + "]";
	} 
	
}

public class MycloneMain {
	public static void main(String[] args) {
		Myclone m1 = new Myclone("aaa", 12);
		Myclone m2 = null;
		try {
			m2 = (Myclone) m1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("m1==m2:" + (m1==m2));
		System.out.println(m1);
		System.out.println(m2);
		//hashcode
		System.out.println("m1 hashCode:" + m1.hashCode());
		System.out.println("m2 hashCode:" + m2.hashCode());
		//getname
		Class<Myclone> c = (Class<Myclone>) m1.getClass();
		Field[] f = c.getFields(); //getFields:멤버변수 목록을 반환하는 메서드
		for(Field ff:f) {
			System.out.println(ff.getName());
		}
	}
}
