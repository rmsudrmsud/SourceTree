package oop1;

class OverloadingTest{

	int add(int a, int b) {

		return a+b;

	}



	// int add(int a, int b) { 파라메터의 개수와 타입이같으면 에러. 둘 중 하나만 다르면 OK

	// return a+b;         return 타입은 상관x

	// }



	int add(int a, int b, int c) {

		return a+b+c;

	}



	float add(float a, float b) {

		return a+b;

	}



	String add(String a, String b) {

		return a+b;

	}



}



public class OverloadingTestMain {



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		OverloadingTest o1 = new OverloadingTest();

		System.out.println(o1.add(1, 2));

		System.out.println(o1.add(1, 2, 3));

		System.out.println(o1.add(1.33f, 2.56f));

		System.out.println(o1.add("1", "2"));

		//호출할 때 파라메터 타입이나 개수로 호출할 오버로딩 메서드 결정

	}



}