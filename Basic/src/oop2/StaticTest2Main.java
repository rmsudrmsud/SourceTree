package oop2;

class StaticTest2{

	public int a; // 일반 멤버

	public static int b; // static 멤버


	//일반 메서드 : 일반 멤버와 static 멤버 모두 사용가능

	public void method1() {

		a = 1;

		b = 2;

		System.out.println("a:"+a+",b:"+b);

	}



	//static 메서드 : 일반 멤버 사용 불가능, static 멤버 사용 가능

	public static void method2() { 

		// a = 1; 일반 멤버변수는 객체를 생성해야 존재할수있는데 static 메서드는 객체 생성전에 사용할 수 있으니 못쓰게막아둠

		b = 2;

		// System.out.println("a:"+a+",b:"+b);

	}

	//일반 메서드 : 메서드안에 일반/static 메서드 모두 호출 가능

	public void method3() {

		method1();

		method2();

	}

	//static 메서드 : 일반메서드 호출 불가능, static 메서드 호출 가능

	public static void method4() {

		// method1();

		method2();

	}



}





public class StaticTest2Main {



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		StaticTest2.method2();

		StaticTest2.method4();



		StaticTest2 st = new StaticTest2(); 

		st.method1(); // 위아래 둘다가능하지만 헷갈릴 수 있으니까 StaticTest2.method2();로 사용권장

		st.method2();

		st.method3();

		st.method4();

	}



}