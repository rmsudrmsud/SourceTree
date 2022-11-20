package oop3;


//부모 클래스

public class Parent {

	protected int age; //같은 패키지에선 아무나. 패키지 밖은 상속관계 클래스

	protected String name;




	public Parent() {

		System.out.println("Parent 생성자");

	}




	public void parentMethod() {

		System.out.println("parentMethod");

	}



}