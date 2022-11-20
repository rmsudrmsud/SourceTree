package Test;



public class Main {



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		test t1 = new test();

		t1.a = 10;

		// t1.b = 20; 멤버번수 b는 접근제어자 private. 클래스 내에서만 사용가능

		t1.c = 30;



		t1.print1();

		t1.print2();



		Test2 t2 = new Test2();

		t2.a = 10;

	}


}