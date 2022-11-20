package oop3;

//extends : 상속키워드

//Parent 클래스를 상속받는 Child클래스 라는 의미

//Private멤버와 생성자는 상속 안됨

//age, name, ParentMethod() 상속받음

public class Child extends Parent {

	private String hobby;



	public Child() {

		System.out.println("Child 생성자");

	}


	public void childMethod() {

		System.out.println("childMethod");

	}


	public String getHobby() {

		return hobby;

	}

	public void setHobby(String hobby) {

		this.hobby = hobby;

	}

}