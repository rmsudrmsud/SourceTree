package Test;


public class test { // 접근제어자 : 클래스나 멤버변수 앞.

	// public 현재패키지, 다른패키지 사용가능

	public int a=1; 

	private int b=2; // private : 현재 클래스 내부에서만 사용

	int c=3; //접근제어자 default.(없음)->같은 패키지 내에서만 사용



	public test(){} // default

	public void print1() {

		System.out.println("a: "+a);

		System.out.println("b: "+b);

		System.out.println("c: "+c);

	}



	void print2() { //다른 패키지에서 사용 불가. default

		System.out.println("a: "+a);

		System.out.println("b: "+b);

		System.out.println("c: "+c);

	}



}



class Test2{//default 다른패키지에서 사용불가

	int a;

} 