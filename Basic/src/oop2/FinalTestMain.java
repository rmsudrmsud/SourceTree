package oop2;

//자바에서 보통 상수를 만들땐 final static ~~~ . 스태틱메모리에 저장되도록

class FinalTest{

	public final static int NUM1 = 10; //상수

	public final static int NUM2;      //상수

	// public final static int NUM3;      //상수 final 은 변할수 없기때문에 선언할 때 값을 주지않으면 에러발생

	public int a=1;                      //일반멤버 변수 

	public static int b=2;               // static 변수



	//static초기화블럭 : static 멤버변수 초기화하는 블럭 

	static {

		NUM2 = 20;    // 상수값 초기화

		b = 100;      //static 멤버 초기화

	}



	//일반 초기화 블럭. 일반멤버변수 초기화하는 블럭

	{

		a= 500;

	}



	//생성자

	public FinalTest() {

		//NUM3 = 30;     //생성자에서 상수를 초기화하는 것 에러발생

		a = 5000;        //일반멤버변수 초기화 가능

		b = 1000;        //static멤버변수 초기화 가능

	}



	//초기화 순서

	//1. 선언문에서 할당

	//2. 초기화 블럭

	//3. 생성자 => 생성자에서 할당한 값이 최종 값



}

public class FinalTestMain {
	public static void main(String[] args) {

		// TODO Auto-generated method stub

		// FinalTest.NUM1 = 200; //상수는 변경 불가. =연산자를 사용할 수 없다.

		// FinalTest.NUM2 = 20;

		FinalTest.b = 200; //b 는 상수가 아님으로 변경 가능

		System.out.println("객체 생성 전");

		System.out.println("FinalTest.NUM1:"+FinalTest.NUM1);

		System.out.println("FinalTest.NUM2:"+FinalTest.NUM2);

		System.out.println("FinalTest.b:"+FinalTest.b);

		FinalTest f = new FinalTest();

		System.out.println("객체 생성 후");

		System.out.println("f.a:"+f.a);

		System.out.println("FinalTest.b:"+FinalTest.b);

	}
}
