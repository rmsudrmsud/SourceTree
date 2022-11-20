package oop2;

public class MemberMain {



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Member m = new Member();

		//m.id = "aaa"; private멤버라 이렇게 사용 x

		m.setId("aaa");// setter를 사용해서 private 멤버에 값 할당



		//System.out.println(m.id); private이라 사용할 수 없음

		System.out.println(m.getId());//getter 를 사용하여 


		Member m2 = new Member("aaa", 2, "222");

		System.out.println("id:"+m2.getId());

		System.out.println("num:"+m2.getNum());

		System.out.println("pwd:"+m2.getPwd());

		System.out.println("m2:"+m2); //객체 출력 : oop2.Member(클래스풀네임)@5aaa6d82(참조값)

		//자바의 모든객체: to String메서드를가짐.

		//to String: 객체를 사용하는 문자열 반환

		System.out.println("m:"+m);

	}



}