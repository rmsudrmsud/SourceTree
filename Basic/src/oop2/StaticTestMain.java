package oop2;

class StaticTest{

	public int a; //일반 멤버변수

	public static int b; //static 멤버변수. 맨 처음에 스태틱메모리에 저장, 클래스 공용으로 사용!



	@Override

	public String toString() { //tostring사용 일반멤버번수 a 나온이후 b추가

		return "StaticTest [a=" + a + ", b=" + b + "]";

	}


}



//현재 생성된 객체가 몇번째 객체인지 출력하기

class Cntobj{

	public static int cnt;

	public Cntobj() {

		cnt++;

		System.out.println(cnt+"번째 객체 생성됨");

	}

}



public class StaticTestMain {



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		//스태틱 멤버는 객체생성 없이 클래스이름.멤버 로 사용가능



		System.out.println(StaticTest.b);



		StaticTest st = new StaticTest();   //스태틱 변수:객체화하면 스태틱 메모리에저장 다른변수 힙에 저장

		st.a++; //a:0 -> 1

		st.b++; //b:0 -> 1

		System.out.println(st);



		StaticTest st2 = new StaticTest();

		st2.a++; //a:0 ->1 st2의 멤버변수 a

		st2.b++; //b:1 ->2 static멤버변수 클래스공용으로 사용

		System.out.println(st2);


		StaticTest st3 = new StaticTest();

		st3.a++; //a:0 ->1 st3의 멤버변수 a

		st3.b++; //b:2 ->3 static멤버변수 클래스공용으로 사용

		System.out.println(st3);



		for(int i = 0;i<5;i++) {

			new Cntobj();

		}



	}



}