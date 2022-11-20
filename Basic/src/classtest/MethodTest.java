package classtest;

class MethodTest1{

	//메서드 정의

	//멤버변수로 사용하는 객체 타입에 제한x

	void printHello() {

		System.out.println("hello");

	}



	void add(int a, int b) {

		int c = a + b;

		System.out.println("합은 "+ c );

	}



	//반환값이 있는 함수. 반환값 : 메서드가 결과값을 호출한 위치로 던져줌(반환). return값

	int add2(int a, int b) {

		return a+b; // return : 메서드 종료, 값 반환 의미.

	}



	String add3(String a, String b) { //함수 앞쪽 메서드가 리턴하는값의 타입으로

		return a+b; //a+b 반환하고 종료

	}



	float fun1() {

		float a = 3.14f;

		return a;

	}



	char fun2() {

		return 'A';

	}



	String fun3() {

		return "abc";

	}



	int[] fun4() {

		return new int[] {1,2,3};

	}



}



public class MethodTest {



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		// 객체 생성

		MethodTest1 mt = new MethodTest1();

		//생성한 객체로 메서드 이름을 부르면 호출됨

		mt.printHello();//메서드 호출은 분기

		mt.printHello();

		mt.printHello();

		//1,2 처럼 전달하는 값을 아규먼트

		//아규먼트는 파라메터의 개수와 타입이 일치하게 전달해야함

		mt.add(1, 2);

		int res1 = mt.add2(2,3); //변수를 타입에담아야 사용가능하므로 int res1

		System.out.println("res1:" +res1);



		String res2 = mt.add3("aaa","nnn");

		System.out.println("res2:"+res2);


		float res3 = mt.fun1();

		System.out.println("res3:"+res3);



		char res4 = mt.fun2();

		System.out.println("res4:"+res4);



		String res5 = mt.fun3();

		System.out.println("res5:"+res5);



		int[] res6 = mt.fun4();

		for(int i=0; i<res6.length;i++) {

			System.out.println(res6[i]);

		}
		
		for(int x: res6) {            
			//('요소 하나 담을 변수' : '리스트')
			System.out.println(x);
		}
		//많이사용되는 반복문 사용법

	}



}