package classtest;

//한 파일에 클래스 여러개 작성 가능.

//public 클래스는 한 파일에 한개만 가능. 

//파일명은 public클래스 이름으로.

class Person{ //멤버변수로 사용하는 객체 타입에 제한x

	int age;

	String name;

	//클래스의 멤버변수는 그 클래스 안에서 모든 메서드가 사용가능

	void printPerson() {

		System.out.println("age:"+ age);

		System.out.println("name:"+ name);

	}

}


public class PersonMain {



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		//객체 생성

		Person p1 = new Person(); //new : 객체 생성 힙에 메모리 할당

		//객체 멤버변수 값 할당

		p1.age = 10;

		p1.name = "aaa";

		p1.printPerson(); //메서드



		Person p2 = new Person();

		p2.age = 20;

		p2.name = "bbb";

		p2.printPerson(); // 메서드



		//객체 멤버변수 값 출력

		// System.out.println("p1.age:"+ p1.age);

		// System.out.println("p1.name:"+ p1.name);

		// System.out.println("p2.age:"+ p2.age);

		// System.out.println("p2.name:"+ p2.name);



	}


}