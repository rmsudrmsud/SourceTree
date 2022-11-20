package oop3;

public class ParentMain {



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Parent p = new Parent();

		p.age = 1;

		p.name = "aaa";

		p.parentMethod();



		Child c = new Child(); //상속받는 하위객체를 생성하면 위에 상위객체를 먼저 순차적으로 생성

		c.age = 2;

		c.name = "bbb";

		c.setHobby("등산"); //hobby setter

		c.parentMethod();

		c.childMethod();

	}



}