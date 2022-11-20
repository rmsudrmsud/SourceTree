package oop1;

class Member{

	String id;

	String pwd;

	String email;



	//메서드 오버로딩

	Member(){} //디폴트 생성자



	Member(String i, String p, String e){

		System.out.println("생성자");

		id = i;

		pwd = p;

		email = e;

		//파라메터 받은 값으로 초기화

	}

	//생성자를 만들지않고 컴파일 시 자동으로 디폴트생성자 (Member(){}) 만들어짐

	//생성자를 하나라도 클래스에 만든다면 디폴트생성자(파라메터X 실행문X) 만들어지지않음



	void printInfo() {

		System.out.println("ㅁㄴㄹ");

		System.out.println(1);

		System.out.println(2.34f);

		System.out.println("id: "+id);

		System.out.println("pwd: "+pwd);

		System.out.println("email: "+email);

	}



}

public class ConstructorTest1Main {



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		//Member m = new Member(); //new : 객체생성. 힙에 메모리할당

		//메서드 호출할 때 파라메터 개수,타입 맞춰주지 않으면 에러

		Member m = new Member("aaa","111","aaa@email.com");

		m.printInfo();



		Member m2 = new Member();

		m2.printInfo(); //객체 타입 값 할당 x null



	}



}